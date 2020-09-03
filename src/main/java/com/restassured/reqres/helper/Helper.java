package com.restassured.reqres.helper;

import java.util.HashMap;
import java.util.Map;

public class Helper {

    public Map<String,Object> createRequest(String name, Object job){
        Map<String,Object> createRequest = new HashMap<String,Object>();
        createRequest.put("name", name);
        createRequest.put("job", job);
        return createRequest;
    }
}
