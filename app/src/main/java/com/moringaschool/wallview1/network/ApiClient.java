package com.moringaschool.wallview1.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.wallview1.Constants.BASE_URL;
import static com.nese.movieapp.util.Constants.BASE_URL;

public class ApiClient {
    static Retrofit retrofit;

    public static ApiService getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return retrofit.create(ApiService.class);
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new RequestInterceptor());
        return client.build();
    }
}
