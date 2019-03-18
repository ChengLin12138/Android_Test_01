package com.example.lenovo.android_test_01.P;

import com.example.lenovo.android_test_01.M.FoodBean;
import com.example.lenovo.android_test_01.M.MainMolder;
import com.example.lenovo.android_test_01.M.MolderInterface;
import com.example.lenovo.android_test_01.V.ViewInterface;

import java.util.List;
//TODO MVP模式中P层
public class MainP implements MolderInterface {
    //TODO 创建M层对象
    MainMolder mainMolder = new MainMolder(this);
    //TODO 拿到V层接口
    ViewInterface viewInterface;

    public MainP(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    public void HandlerStart() {
        mainMolder.getData();
    }

    ;

    @Override
    public void molderSuccess(List<FoodBean.DataBean> list) {
        //TODO 往V层接口赋值
        viewInterface.viewSuccess(list);
    }

    @Override
    public void molderFalie() {
        viewInterface.viewFalie();
    }
}
