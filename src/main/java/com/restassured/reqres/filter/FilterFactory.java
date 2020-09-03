package com.restassured.reqres.filter;

import io.restassured.spi.AuthFilter;

public class FilterFactory{

    public AuthFilter filterData(){
        return new Filter();
    }




}
