package com.cuipengyu.greendaodemo.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Create by    ： 崔鹏宇 
 * Time  is     ： 2018/5/21
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
@Entity
public    class Customer   {
    @Id
    private Long id;

    @Generated(hash = 470110355)
    public Customer(Long id) {
        this.id = id;
    }

    @Generated(hash = 60841032)
    public Customer() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
