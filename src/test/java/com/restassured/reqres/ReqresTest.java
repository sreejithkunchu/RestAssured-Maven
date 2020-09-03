package com.restassured.reqres;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.reqres.beans.UserData;
import com.restassured.reqres.beans.UserDataLists;
import com.restassured.reqres.helper.Helper;
import com.restassured.reqres.service.ReqresApi;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReqresTest {

    private static ReqresApi reqresApi = new com.restassured.reqres.service.Impls.ReqresApi();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Parameters({"userId"})
    public void getUserData(int userId) {
        UserData userData = reqresApi.getUser(userId);
    }

    @Test
    @Parameters({"pageNumber"})
    public void getListUsersData(int pageNumber) {
        UserDataLists userDataLists = reqresApi.getUserList(pageNumber);
    }

    @Test
    @Parameters({"name", "job"})
    public void createUser(String name, Object job) {
        Helper helper = new Helper();
        Map<String, Object> respose = reqresApi.createUsers(helper.createRequest(name, job));
        try {
            objectMapper.writeValue(new File("src/test/resources/validationFiles/output.json"), respose);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Parameters({"pageNumber", "filePath"})
    public void getListUsersDataAndVerifyViaFileMap(int pageNumber, String filePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        Map<String, Object> expected = null;
        try {
            expected = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> actual = objectMapper.convertValue(reqresApi.getUserList(pageNumber), Map.class);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void createUserViaFile() {
        List<Map<String, Object>> inputRequest = new ArrayList<Map<String,Object>>();
        try {
            inputRequest = objectMapper.readValue(new File(ClassLoader.getSystemResource("validationFiles/input.json").getFile()), new TypeReference<List<Map<String,Object>>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map<String,Object> input : inputRequest){
            reqresApi.createUsers(input);
        }

    }


}
