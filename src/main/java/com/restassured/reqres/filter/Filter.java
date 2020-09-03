package com.restassured.reqres.filter;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.spi.AuthFilter;

public class Filter implements AuthFilter {

    public Response filter( FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext){
        filterableRequestSpecification.baseUri("https://reqres.in/");
        filterableRequestSpecification.header("Content-Type", "application/Json");
        return filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
    }


}
