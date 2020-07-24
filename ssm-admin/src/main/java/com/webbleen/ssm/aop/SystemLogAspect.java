package com.webbleen.ssm.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.webbleen.ssm.bo.SystemLog;
import com.webbleen.ssm.shiro.AdminRealm;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 统一日志处理切面
 */
@Aspect
@Component
@Order(1)
public class SystemLogAspect {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.webbleen.ssm.controller.*.*(..))")
    public void systemLog() {
    }

    @Before("systemLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }


    @AfterReturning(value = "systemLog()", returning = "result")
    public void doAfterReturning(Object result) throws Throwable {
        logger.info("Result : {}", result);
    }

    @Around("systemLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录请求信息(通过Logstash传入Elasticsearch)
        SystemLog systemLog = new SystemLog();
        Object result = joinPoint.proceed();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        long endTime = System.currentTimeMillis();
        String urlStr = request.getRequestURL().toString();
        systemLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        systemLog.setIp(request.getRemoteUser());
        systemLog.setMethod(request.getMethod());
        systemLog.setParameter(getParameter(method, joinPoint.getArgs()));
        systemLog.setResult(result);
        systemLog.setSpendTime((int) (endTime - startTime));
        systemLog.setStartTime(startTime);
        systemLog.setUri(request.getRequestURI());
        systemLog.setUrl(request.getRequestURL().toString());

        Map<String,Object> logMap = new HashMap<>();
        logMap.put("url",systemLog.getUrl());
        logMap.put("method",systemLog.getMethod());
        logMap.put("parameter",systemLog.getParameter());
        logMap.put("spendTime",systemLog.getSpendTime());
        logMap.put("description",systemLog.getDescription());
        //logger.info("{}", JSONUtil.parse(webLog));
        //logger.info(String.valueOf(logMap));
        logger.info("SystemLogAspect : {}", systemLog);

        return result;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }
}
