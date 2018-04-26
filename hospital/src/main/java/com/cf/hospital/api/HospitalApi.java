package com.cf.hospital.api;

import com.cf.hospital.base.Constant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Michael on 2018/4/11.
 */

public class HospitalApi {

    public static HospitalApi instance;

    private HospitalService service;

    public HospitalApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(HospitalService.class);
    }

    public static HospitalApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new HospitalApi(okHttpClient);
        return instance;
    }
}
