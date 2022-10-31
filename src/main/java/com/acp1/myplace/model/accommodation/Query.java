package com.acp1.myplace.model.accommodation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Query {

    private Integer page;
    private Integer pageSize;
}
