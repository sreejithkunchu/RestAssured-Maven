package com.restassured.reqres.service.Impls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.reqres.beans.UserData;
import com.restassured.reqres.beans.UserDataLists;
import com.restassured.reqres.filter.FilterFactory;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class ReqresApi implements com.restassured.reqres.service.ReqresApi {

    ObjectMapper objectMapper = new ObjectMapper();
    FilterFactory filter1 = new FilterFactory();




    public UserData getUser(int userId) {


        JsonNode jsonNode = given().auth().none().baseUri("https://reqres.in/").log().all().pathParams("userId", userId)
                .when().contentType(ContentType.JSON).get(USERS)
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().response().as(JsonNode.class);
        return objectMapper.convertValue(jsonNode, UserData.class);
    }

    public UserDataLists getUserList(int pageNumber) {
        JsonNode jsonNode = given().auth().none().baseUri("https://reqres.in/").log().all().pathParams("pageNumber", pageNumber).
                when().contentType(ContentType.JSON).get(USERS_LIST)
                .then().log().all().statusCode(HttpStatus.SC_OK).extract().response().as(JsonNode.class);

        return objectMapper.convertValue(jsonNode, UserDataLists.class);
    }

    public Map<String,Object> createUsers(Map<String, Object> body){
        return given().auth().none().baseUri("https://reqres.in/").log().all()
                .when().contentType(ContentType.JSON).body(body).post(CREATE_USERS)
                .then().log().all().statusCode(HttpStatus.SC_CREATED).extract().response().as(Map.class);
    }




}
