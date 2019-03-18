package com.example.lenovo.android_test_01.V;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lenovo.android_test_01.M.FoodBean;
import com.example.lenovo.android_test_01.P.MainP;
import com.example.lenovo.android_test_01.R;
import com.example.lenovo.android_test_01.RvAdapter;

import java.util.List;
//TODO MVP模式中的View层
public class MainActivity extends AppCompatActivity implements ViewInterface{

    private RecyclerView Rv;
    RvAdapter adapter;
    MainP mainP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //TODO 拿到控件
        Rv = (RecyclerView) findViewById(R.id.Rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        Rv.setLayoutManager(manager);
        Rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new RvAdapter();

        mainP = new MainP(this);
        mainP.HandlerStart();

    }
    //TODO 拿到数据成功后
    @Override
    public void viewSuccess(List<FoodBean.DataBean> list) {
        //TODO 往适配器里传值
        adapter.setList(list);
        Rv.setAdapter(adapter);

    }

    @Override
    public void viewFalie() {
        Toast.makeText(this,"加载失败",Toast.LENGTH_SHORT).show();
    }
}
