package com.restassured.reqres.beans;

public class AD {
    private String company;
    private String url;
    private String text;

    public void setCompany(String company){
        this.company = company;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getCompany(){
        return company;
    }

    public String getUrl(){
        return url;
    }

    public String getText(){
        return text;
    }

    public AD(){

    }

}

