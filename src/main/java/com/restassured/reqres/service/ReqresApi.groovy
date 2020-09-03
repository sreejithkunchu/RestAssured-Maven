package com.restassured.reqres.service


import com.restassured.reqres.beans.UserData
import com.restassured.reqres.beans.UserDataLists

interface ReqresApi {

    String USERS = "api/users/{userId}";
    String USERS_LIST = "api/users?page={pageNumber}";
    String CREATE_USERS = "api/users/";

    UserData getUser(int userId);

    UserDataLists getUserList(int pageNumber);

    Map<String,Object> createUsers(Map<String, Object> body);

}