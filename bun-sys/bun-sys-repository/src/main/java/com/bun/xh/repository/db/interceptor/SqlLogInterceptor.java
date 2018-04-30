package com.bun.xh.repository.db.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

@Intercepts({
        @org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "prepare", args = {
                java.sql.Connection.class }) })
public class SqlLogInterceptor implements Interceptor{
    private static Logger logger = Logger.getLogger(SqlLogInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation
                .getTarget();
        BoundSql bSql = statementHandler.getBoundSql();
        Object param = statementHandler.getParameterHandler()
                .getParameterObject();

        StringBuilder sb = new StringBuilder();

        sb.append(new StringBuilder().append("sql:---->\r\n")
                .append(removeBreakingWhitespace(bSql.getSql())).append("\r\n")
                .toString());

        List<ParameterMapping> paramList = bSql.getParameterMappings();
        for (ParameterMapping mapping : paramList) {
            String proName = mapping.getProperty();
            try {
                sb.append(new StringBuilder().append("[").append(proName)
                        .append(":")
                        .append(BeanUtils.getProperty(param, proName))
                        .append("]").toString());
            } catch (Exception e) {
                sb.append(new StringBuilder().append("[").append(proName)
                        .append(":").append(param).append("]").toString());
            }
        }
        sb.append("-------------------------------");

        logger.info(sb.toString());

        return invocation.proceed();
    }

    protected String removeBreakingWhitespace(String original) {
        StringTokenizer whitespaceStripper = new StringTokenizer(original);
        StringBuilder builder = new StringBuilder();
        for (; whitespaceStripper.hasMoreTokens(); builder.append(" ")) {
            builder.append(whitespaceStripper.nextToken());
        }
        return builder.toString();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties arg0) {
    }
}