package com.fanchen.pojo;

/**
 * Created by Administrator on 2017/10/26.
 */

public class User {
    private int id;
    private long mobile;
    private long status;
    private long level;
    private String name;
    private String password;
    private String declaration;
    private String portrait;
    private String create_at;

    public void setId(int id) {
        this.id = id;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public long getMobile() {
        return mobile;
    }

    public long getStatus() {
        return status;
    }

    public long getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDeclaration() {
        return declaration;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getCreate_at() {
        return create_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", status=" + status +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", declaration='" + declaration + '\'' +
                ", portrait='" + portrait + '\'' +
                ", create_at='" + create_at + '\'' +
                '}';
    }
}
