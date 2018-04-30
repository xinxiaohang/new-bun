package com.bun.xh.repository.db.interceptor;

public abstract class AbstractDialect {
    protected static final String SQL_END_DELIMITER = ";";

    protected String trim(String sql) {
        sql = sql.trim();
        if (sql.endsWith(SQL_END_DELIMITER)) {
            sql = sql.substring(0,
                    sql.length() - 1 - SQL_END_DELIMITER.length());
        }
        return sql;
    }

    public boolean supportsLimit() {
        return true;
    }

    public boolean supportOffsetLimit() {
        return true;
    }

    public abstract String getLimitString(String sql, int offset, int maxRow);
}