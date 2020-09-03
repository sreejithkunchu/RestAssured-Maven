package com.restassured.reqres.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDataLists {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private AD ad;

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void setAd(AD ad) {
        this.ad = ad;
    }

    public List<Data> getData() {
        return data;
    }

    public AD getAd() {
        return ad;
    }

    public void setPage(int page){
        this.page = page;
    }

    public void setPer_page(int per_page){
        this.per_page = per_page;
    }
     public void setTotal(int total){
        this.total = total;
     }

     public void setTotal_pages(int total_pages){
        this.total_pages = total_pages;
     }

     public int getPage(){
        return page;
     }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public UserDataLists() {

    }


}
