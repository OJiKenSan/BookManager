package com.example.bookmanager.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.bookmanager.Fragment.ManageFragment;
import com.example.bookmanager.Fragment.MineFragment;
import com.example.bookmanager.R;
import com.example.bookmanager.Util.WindowUtil;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_mine;
    private LinearLayout ll_guanli;
    private ManageFragment manageFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        change();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        ll_mine = (LinearLayout) findViewById(R.id.ll_mine);
        ll_guanli = (LinearLayout) findViewById(R.id.ll_guanli);
    }

    /**
     * 初始化Fragment显示
     */
    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_frame, new ManageFragment());
        ft.commit();
    }

    /**
     * 更换Fragment方法
     *
     * @param fragment
     */
    private void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();
    }

    /**
     * 底部变换
     */
    private void change() {
        initView();
        //管理
        ll_guanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (manageFragment == null) {
                    manageFragment = new ManageFragment();
                }
                changeFragment(manageFragment);
            }
        });
        //我的
        ll_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                changeFragment(mineFragment);
            }
        });

    }



}
