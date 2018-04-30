package com.bun.xh.repository.db.interceptor;

public class MySql5Dialect extends AbstractDialect{
    @Override
    public String getLimitString(String sql, int offset, int maxRow) {
        sql = trim(sql);
        StringBuilder pagingSelect = new StringBuilder(sql.length() + 40)
                .append(sql);
        if (offset > 0) {
            return pagingSelect.append(" limit ").append(offset).append(", ")
                    .append(maxRow).toString();
        }
        return pagingSelect.append(" limit ").append(maxRow).toString();
    }
}