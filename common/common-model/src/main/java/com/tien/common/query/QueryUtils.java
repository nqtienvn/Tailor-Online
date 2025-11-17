package com.tien.common.query;

import org.springframework.util.StringUtils;

public class QueryUtils {
    public static StringBuilder createOrderQuery(String sortBy) {
        StringBuilder hql = new StringBuilder(" ");
        if (StringUtils.hasLength(sortBy)) {
            hql.append(" ORDER BY c.").append(sortBy.replace(".", " "));
        } else {
            hql.append(" ORDER BY c.modifiedDate DESC");
        }
        return hql;
    }
}
