package com.jsecode.androidmvp.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Daobean {
    @Id
    public Long id;


    //@Property(nameInDb = "USERNAME")//该字段名为...(大写)
    @Property
    public String username;

    @Generated(hash = 573943057)
    public Daobean(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Generated(hash = 1831228405)
    public Daobean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
