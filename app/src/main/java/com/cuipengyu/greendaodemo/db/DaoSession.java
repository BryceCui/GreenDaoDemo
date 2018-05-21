package com.cuipengyu.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.cuipengyu.greendaodemo.db.Book;
import com.cuipengyu.greendaodemo.db.User;
import com.cuipengyu.greendaodemo.db.Order;
import com.cuipengyu.greendaodemo.db.Customer;

import com.cuipengyu.greendaodemo.db.BookDao;
import com.cuipengyu.greendaodemo.db.UserDao;
import com.cuipengyu.greendaodemo.db.OrderDao;
import com.cuipengyu.greendaodemo.db.CustomerDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig orderDaoConfig;
    private final DaoConfig customerDaoConfig;

    private final BookDao bookDao;
    private final UserDao userDao;
    private final OrderDao orderDao;
    private final CustomerDao customerDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        customerDaoConfig = daoConfigMap.get(CustomerDao.class).clone();
        customerDaoConfig.initIdentityScope(type);

        bookDao = new BookDao(bookDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        orderDao = new OrderDao(orderDaoConfig, this);
        customerDao = new CustomerDao(customerDaoConfig, this);

        registerDao(Book.class, bookDao);
        registerDao(User.class, userDao);
        registerDao(Order.class, orderDao);
        registerDao(Customer.class, customerDao);
    }
    
    public void clear() {
        bookDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
        orderDaoConfig.clearIdentityScope();
        customerDaoConfig.clearIdentityScope();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

}
