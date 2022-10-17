package com.acp1.myplace.factories;

import com.acp1.myplace.model.accommodation.Query;

import java.util.Map;

public class QueryFactory {

    private static final String PAGE = "page";
    private static final String PAGE_SIZE = "pageSize";

    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    public static Query create(Map<String, String> queryParams) {
        Query.QueryBuilder queryBuilder = Query.builder().page(DEFAULT_PAGE).pageSize(DEFAULT_PAGE_SIZE);
        if (queryParams.containsKey(PAGE)) {
            queryBuilder.page(Integer.parseInt(queryParams.get(PAGE)));
        }
        if (queryParams.containsKey(PAGE_SIZE)) {
            queryBuilder.pageSize(Integer.parseInt(queryParams.get(PAGE_SIZE)));
        }
        return queryBuilder.build();
    }

}
