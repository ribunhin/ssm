package com.webbleen.ssm.mybatis.plugin;


import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * mybatis generator生成注释插件
 */
public class CommentPlugin extends PluginAdapter {

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.getJavaDocLines().clear();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * Table: " + introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(" */");
        return true;
    }

    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        this.comment(field, introspectedTable, introspectedColumn);
        return true;
    }

    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return true;
    }

    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addImportedType(new FullyQualifiedJavaType(
                "org.apache.ibatis.annotations.Mapper"));
        interfaze.addAnnotation("@Mapper");
        return true;
    }

    private void comment(JavaElement element, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        element.getJavaDocLines().clear();
        element.addJavaDocLine("/**");
        //获取列字段注解
        String remark = introspectedColumn.getRemarks();
        if (remark != null && remark.length() > 1) {
            element.addJavaDocLine(" * " + remark);
            element.addJavaDocLine(" *");
        }
        element.addJavaDocLine(" * Column:    " + introspectedColumn.getActualColumnName());
        element.addJavaDocLine(" * Length:    " + introspectedColumn.getLength());
        element.addJavaDocLine(" * DefaultValue:  " + (StringUtility.stringHasValue(introspectedColumn.getDefaultValue()) ? introspectedColumn.getDefaultValue() : "无默认值"));
        element.addJavaDocLine(" * Nullable:  " + introspectedColumn.isNullable());
        boolean autoIncrement = introspectedColumn.isAutoIncrement();
        if (autoIncrement){
            element.addJavaDocLine(" * AutoIncrement:  true");
        }
        element.addJavaDocLine(" */");
    }


    void commentResultMap(XmlElement element, IntrospectedTable introspectedTable) {
        List<Element> es = element.getElements();
        if (!es.isEmpty()) {
            String alias = introspectedTable.getTableConfiguration().getAlias();
            int aliasLen = -1;
            if (alias != null) {
                aliasLen = alias.length() + 1;
            }

            Iterator<Element> it = es.iterator();
            HashMap map = new HashMap();

            while(true) {
                while(it.hasNext()) {
                    Element e = (Element)it.next();
                    if (e instanceof TextElement) {
                        it.remove();
                    } else {
                        XmlElement el = (XmlElement)e;
                        List<Attribute> as = el.getAttributes();
                        if (!as.isEmpty()) {
                            String col = null;
                            Iterator i$ = as.iterator();

                            while(i$.hasNext()) {
                                Attribute a = (Attribute)i$.next();
                                if (a.getName().equalsIgnoreCase("column")) {
                                    col = a.getValue();
                                    break;
                                }
                            }

                            if (col != null) {
                                if (aliasLen > 0) {
                                    col = col.substring(aliasLen);
                                }

                                IntrospectedColumn ic = introspectedTable.getColumn(col);
                                if (ic != null) {
                                    StringBuilder sb = new StringBuilder();
                                    if (ic.getRemarks() != null && ic.getRemarks().length() > 1) {
                                        sb.append("<!-- ");
                                        sb.append(ic.getRemarks());
                                        sb.append(" -->");
                                        map.put(el, new TextElement(sb.toString()));
                                    }
                                }
                            }
                        }
                    }
                }

                if (map.isEmpty()) {
                    return;
                }

                Set<Element> set = map.keySet();
                Iterator i$ = set.iterator();

                while(i$.hasNext()) {
                    Element e = (Element)i$.next();
                    int id = es.indexOf(e);
                    es.add(id, (Element) map.get(e));
                    es.add(id, new TextElement(""));
                }

                return;
            }
        }
    }

    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.removeAttribute(element.getAttributes(), "parameterType");
        return true;
    }

    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.removeAttribute(element.getAttributes(), "parameterType");
        return true;
    }

    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.removeAttribute(element.getAttributes(), "parameterType");
        return true;
    }

    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.removeAttribute(element.getAttributes(), "parameterType");
        return true;
    }

    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        this.removeAttribute(element.getAttributes(), "parameterType");
        return true;
    }

    private void removeAttribute(List<Attribute> as, String name) {
        if (!as.isEmpty()) {
            Iterator it = as.iterator();

            Attribute attr;
            do {
                if (!it.hasNext()) {
                    return;
                }

                attr = (Attribute)it.next();
            } while(!attr.getName().equalsIgnoreCase(name));

            it.remove();
        }
    }
}