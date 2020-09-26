package com.vineela.reterofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by VINEELA on 17-10-2018.
 */

public interface ApiInterface {
    public String BASEURL="https://simplifiedcoding.net/demos/";
    @GET("marvel")
    public Call<List<ModelClass>> getdata();
}
