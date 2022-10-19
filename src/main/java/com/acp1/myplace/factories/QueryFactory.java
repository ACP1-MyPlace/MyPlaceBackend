package com.acp1.myplace.factories;

import com.acp1.myplace.model.accommodation.Query;
import org.springframework.data.domain.Pageable;

import static java.util.Objects.nonNull;

public class QueryFactory {

    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    public static Query create(Pageable queryParams) {
        Query.QueryBuilder queryBuilder = Query.builder().page(DEFAULT_PAGE).pageSize(DEFAULT_PAGE_SIZE);
        if (nonNull(queryParams.getPageNumber())) {
            queryBuilder.page(queryParams.getPageNumber());
        }
        if (nonNull(queryParams.getPageSize())) {
            queryBuilder.pageSize(queryParams.getPageSize());
        }
        return queryBuilder.build();
    }

}
