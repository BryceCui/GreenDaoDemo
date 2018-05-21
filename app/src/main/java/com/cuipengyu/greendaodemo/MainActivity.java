package com.cuipengyu.greendaodemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cuipengyu.greendaodemo.db.Book;
import com.cuipengyu.greendaodemo.db.BookDao;
import com.cuipengyu.greendaodemo.db.Customer;
import com.cuipengyu.greendaodemo.db.DaoMaster;
import com.cuipengyu.greendaodemo.db.DaoSession;
import com.cuipengyu.greendaodemo.db.Order;
import com.cuipengyu.greendaodemo.db.User;
import com.cuipengyu.greendaodemo.db.UserDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDao mUserDao;
    private DaoMaster daoMaster;
    private BookDao mBookDao;
    private DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDao();
//        insertUser();
//        insertReplace();
//        inserUsers();

//        insertReplaces();
//        loadAllUser();
//        whereQueryRaw();
//        whereQueryId();
//        whereQueryRaw();
//        queryBuilderList();
//          deleteId();
//        queryDelete();

//        queryUpdata();
//        List<Order> orders = new ArrayList<>();
//        Order order = new Order();
//        order.setId(null);
//        order.setCustomerId(1001L);
//        orders.add(order);
//        Order order1 = new Order();
//        order1.setId(null);
//        order1.setCustomerId(1001L);
//        orders.add(order1);
//        Order order2 = new Order();
//        order2.setId(null);
//        order2.setCustomerId(1002L);
//        orders.add(order2);
//        mDaoSession.getOrderDao().insertInTx(orders);
       List<Order>  order =    mDaoSession.getOrderDao().loadAll();
        for (int i = 1; i <order.size() ; i++) {
         Customer customer=  new Customer(order.get(i).getCustomerId());
            mDaoSession.getCustomerDao().insert(customer);
        }
        Log.e("id-----0",  mDaoSession.getOrderDao().load(1l).getMCustomer().toString()+"");
//        Log.e("id-----0",  mDaoSession.getOrderDao().load(2l)+"");
//        Log.e("id-----0",  mDaoSession.getOrderDao().load(3l)+"");
      ;
    }

    public void initDao() {
        DaoMaster.OpenHelper openHelper = new DaoMaster.OpenHelper(MyAppLication.getMlication(), "test.db") {
            @Override
            public void onCreate(Database db) {
                super.onCreate(db);
            }
        };
        SQLiteDatabase database = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
        mUserDao = mDaoSession.getUserDao();
        mBookDao = mDaoSession.getBookDao();

    }

    public void queryUpdata() {
        QueryBuilder<User> queryBuilder = mUserDao.queryBuilder();
        User user = queryBuilder.where(UserDao.Properties.Name.eq("cuipengyu")).build().unique();
        user.setName("cuipengyuUpd1");

        mUserDao.insertOrReplace(user);
    }

    //添加数据
    public void insertUser() {
        User user = new User();
        user.setName("cuipengyu");
        user.setPassWord("123456");
        Book book = new Book();
        mBookDao.insert(book);
        mUserDao.insert(user);
        User user1 = new User();
        user1.setName("cuipengyu1");
        user1.setPassWord("123456");
        mUserDao.insert(user1);
    }

    public void updata() {
        User user = new User();
        user.setId(9l);
        user.setName("cuipengyuupdata");
        user.setPassWord("updata");
        mUserDao.update(user);
    }

    public void deleteUser() {
        User user = new User(1l, "cuipengyu", "123", 1l);
        mUserDao.delete(user);
    }

    //查询所有
    public void loadAllUser() {
//        return mUserDao.loadAll();
        List<User> users = mUserDao.loadAll();
        for (int i = 0; i < users.size(); i++) {
            Log.e("users", users.get(i).getName());
        }
    }

    public void queryBuilderList() {
        List<User> users = mUserDao.queryBuilder().list();
        for (int i = 0; i < users.size(); i++) {
            Log.e("users", users.get(i).getName());
        }
    }

    //根据id查询
    public void whereQueryId() {
        mUserDao.loadByRowId(1);
        Log.e("whereQueryId", mUserDao.loadByRowId(1).getName().toString() + "");
    }

    //条件查询
    public void whereQueryRaw() {
        Log.e("whereQueryRaw", mUserDao.queryRaw("where Name=?", "cuipengyu").size() + "");
        mUserDao.queryRaw("where Name=?", "cuipengyu");

        mUserDao.queryBuilder().where(UserDao.Properties.Name.eq("cuipengyu")).build().list().size();
        Log.e("queryBuilder", mUserDao.queryBuilder().where(UserDao.Properties.Name.eq("cuipengyu")).build().unique() + "");

    }

    public void inserUsers() {
        List<User> users = new ArrayList<>();
        User user = new User(null, "cuipengyu01", "dddd", null);
        User user1 = new User(null, "cuipengyu02", "dddd", null);
        User user2 = new User(null, "cuipengyu03", "dddd", null);
        User user3 = new User(null, "cuipengyu04", "dddd", null);
        User user4 = new User(null, "cuipengyu05", "dddd", null);
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        mUserDao.insertInTx(users);
        Book book = new Book(null, "diyi");
        mBookDao.insert(book);
    }

    public void insertReplace() {
        User user = new User();
        user.setName("cuipengyu05");
        user.setPassWord("1234");
        mUserDao.insertOrReplace(user);
    }

    public void insertReplaces() {
        List<User> users = new ArrayList<>();
        users.add(new User(null, "cuipengyu01", "111", null));
        users.add(new User(null, "cuipengyu02", "111", null));
        users.add(new User(null, "cuipengyu03", "111", null));
        users.add(new User(null, "cuipengyu04", "111", null));
        users.add(new User(null, "cuipengyu05", "111", null));
        mUserDao.insertOrReplaceInTx(users);
    }

    //根据id删除
    public void deleteId() {
        mUserDao.deleteByKey(0l);
    }

    public void queryDelete() {
        QueryBuilder<User> queryBuilder = mUserDao.queryBuilder();
        DeleteQuery<User> userDeleteQuery = queryBuilder.where(UserDao.Properties.Name.eq("cuipengyu01")).buildDelete();
        userDeleteQuery.executeDeleteWithoutDetachingEntities();
    }

    public void deleteAll() {
        mUserDao.deleteAll();
    }


}
