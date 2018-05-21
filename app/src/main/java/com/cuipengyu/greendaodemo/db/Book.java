package com.cuipengyu.greendaodemo.db;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Create by    ： 崔鹏宇 
 * Time  is     ： 2018/5/21
 * Email        ： cuipengyusoul@gmail.com
 * Github       ： https://github.com/SolitarySoul
 * Instructions ：
 */
@Entity
public    class Book   {
    @Id
    private Long bookId;
    @Unique
    @NonNull
    private String bookName;
    @Generated(hash = 1909870818)
    public Book(Long bookId, @NonNull String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
