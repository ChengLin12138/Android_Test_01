package com.example.lenovo.android_test_01.M;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MolderRetrofit {

    @GET()
    Observable<FoodBean> getData(@Url String url);

}
