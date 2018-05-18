package com.cuipengyu.greendaodemo.db;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Create by    ： 崔鹏宇
 * Time  is     ： 2018/5/18
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
@Entity
public class User {
    @Id
    private Long id;
    @Property(nameInDb = "Name")
    @NonNull
    @Unique
    private String name;
    @NonNull
    private String passWord;
    @Transient
    private String Transient;
    @Generated(hash = 446776444)
    public User(Long id, @NonNull String name, @NonNull String passWord) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
