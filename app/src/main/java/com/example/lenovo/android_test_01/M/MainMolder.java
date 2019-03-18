package com.example.lenovo.android_test_01.M;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//TODO MVP模式中Molder层
public class MainMolder {
    //TODO 拿到Molder层接口
    MolderInterface molderInterface;
    //TODO 网址接口
    String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    String baseUrl = "http://www.qubaobei.com/ios/cf/";

    public MainMolder(MolderInterface molderInterface) {
        this.molderInterface = molderInterface;
    }

    public void getData() {
        //TODO RXJAVA + Retrofit解析数据
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit build = builder.build();
        MolderRetrofit molderRetrofit = build.create(MolderRetrofit.class);
        molderRetrofit.getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FoodBean foodBean) {
                        List<FoodBean.DataBean> data = foodBean.getData();
                        //TODO 往Molder层接口中赋值
                        molderInterface.molderSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
