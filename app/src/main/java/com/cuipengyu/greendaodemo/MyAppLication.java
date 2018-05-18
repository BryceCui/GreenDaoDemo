package com.cuipengyu.greendaodemo;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cuipengyu.greendaodemo.db.DaoMaster;
import com.cuipengyu.greendaodemo.db.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/5/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
public class MyAppLication extends Application {
    private static MyAppLication mLication;

    public static Context getMlication() {
        return mLication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mLication = this;

    }


}
