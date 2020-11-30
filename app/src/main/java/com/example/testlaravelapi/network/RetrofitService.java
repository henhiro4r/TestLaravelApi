package com.example.testlaravelapi.network;

import android.util.Log;

import com.example.testlaravelapi.model.response.EventResponse;
import com.example.testlaravelapi.model.response.TokenResponse;
import com.example.testlaravelapi.utils.Constants;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Endpoints endpoints;
    private static RetrofitService service;
    private static final String TAG = "RetrofitService";

    private RetrofitService(String token) {
        Log.d(TAG, "RetrofitService: " + token);

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (token.equals("")) {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            });
        } else {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            });
        }

        endpoints = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(Endpoints.class);
    }

    public static RetrofitService getInstance(String token) {
        if (service == null) {
            service = new RetrofitService(token);
        } else if (!token.equals("")) {
            service = new RetrofitService(token);
        }
        return service;
    }

    public Call<TokenResponse> login(String email, String password) {
        return endpoints.login(email, password);
    }

    public Call<EventResponse> getEvents() {
        return endpoints.getEvents();
    }

    public Call<JsonObject> logout() {
        return endpoints.logout();
    }
}
