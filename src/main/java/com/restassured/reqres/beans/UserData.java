package com.restassured.reqres.beans;


public class UserData {

    private Data data;
    private AD ad;


    public void setData(Data data){
        this.data = data;
    }

    public void setAd( AD ad){
        this.ad = ad;
    }

    public Data getData(){
        return data;
    }

    public AD getAd(){
        return ad;
    }

    public UserData(){

    }


}
