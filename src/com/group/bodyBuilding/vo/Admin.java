package com.group.bodyBuilding.vo;

import java.util.Date;

public class Admin {
    private String id;
    private String name;
    private String password;
    private String lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastlogintime) {
        this.lastLoginTime = lastlogintime;
    }
}
