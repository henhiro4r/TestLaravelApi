package com.example.testlaravelapi.network;

import com.example.testlaravelapi.model.response.EventResponse;
import com.example.testlaravelapi.model.response.TokenResponse;
import com.example.testlaravelapi.utils.Constants;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login (@Field("email") String email, @Field("password") String password);

    @GET("events")
    Call<EventResponse> getEvents();

    @POST("logout")
    Call<JsonObject> logout();
}
