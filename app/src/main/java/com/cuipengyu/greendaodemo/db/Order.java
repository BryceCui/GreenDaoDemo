package com.cuipengyu.greendaodemo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Create by    ： 崔鹏宇 
 * Time  is     ： 2018/5/21
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
@Entity
public    class Order   {
    @Id
    private Long id;
    private long customerId;
    @ToOne(joinProperty = "customerId")
    private Customer mCustomer;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 949219203)
    private transient OrderDao myDao;
    @Generated(hash = 1580440720)
    public Order(Long id, long customerId) {
        this.id = id;
        this.customerId = customerId;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    @Generated(hash = 1909923493)
    private transient Long mCustomer__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1198111903)
    public Customer getMCustomer() {
        long __key = this.customerId;
        if (mCustomer__resolvedKey == null
                || !mCustomer__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CustomerDao targetDao = daoSession.getCustomerDao();
            Customer mCustomerNew = targetDao.load(__key);
            synchronized (this) {
                mCustomer = mCustomerNew;
                mCustomer__resolvedKey = __key;
            }
        }
        return mCustomer;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1121236020)
    public void setMCustomer(@NotNull Customer mCustomer) {
        if (mCustomer == null) {
            throw new DaoException(
                    "To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.mCustomer = mCustomer;
            customerId = mCustomer.getId();
            mCustomer__resolvedKey = customerId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 965731666)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderDao() : null;
    }
}
