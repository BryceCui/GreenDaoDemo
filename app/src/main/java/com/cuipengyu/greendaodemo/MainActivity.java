package com.cuipengyu.greendaodemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cuipengyu.greendaodemo.db.DaoMaster;
import com.cuipengyu.greendaodemo.db.DaoSession;
import com.cuipengyu.greendaodemo.db.User;
import com.cuipengyu.greendaodemo.db.UserDao;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDao();
//        insertUser();
//        insertReplace();
        loadAllUser();
        whereQueryRaw();

    }

    public void initDao() {
        DaoMaster.OpenHelper openHelper = new DaoMaster.OpenHelper(MyAppLication.getMlication(), "test.db") {
            @Override
            public void onCreate(Database db) {
                super.onCreate(db);
            }
        };
        SQLiteDatabase database = openHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    //查询所有
    public List<User> loadAllUser() {
        return mDaoSession.getUserDao().loadAll();
    }
    //根据id查询
    public void whereQueryId() {
        mDaoSession.getUserDao().loadByRowId(1);
        Log.e("whereQueryId", mDaoSession.getUserDao().loadByRowId(1) + "");
    }
    //条件查询
    public void whereQueryRaw(){
        Log.e("whereQueryRaw", mDaoSession.getUserDao().queryRaw("where Name=?","cuipengyu").size()+"");
        mDaoSession.getUserDao().queryRaw("where Name=?","cuipengyu");

        mDaoSession.getUserDao().queryBuilder().where(UserDao.Properties.Name.eq("cuipengyu")).build().list().size();
        Log.e("queryBuilder", mDaoSession.getUserDao().queryBuilder().where(UserDao.Properties.Name.eq("cuipengyu")).build().unique()+"");

    }

    //添加数据
    public void insertUser() {
        User user = new User();
        user.setName("cuipengyu");
        user.setPassWord("123456");
        mDaoSession.getUserDao().insert(user);
        User user1 = new User();
        user1.setName("cuipengyu1");
        user1.setPassWord("123456");
        mDaoSession.getUserDao().insert(user1);
    }

    public void insertReplace() {
        User user = new User();
        user.setName("cuipengyu2");
        user.setPassWord("1234567890");
        mDaoSession.insertOrReplace(user);
    }


}
