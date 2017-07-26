package com.telecom.domain;

import java.io.Serializable;

/**
 * Created by huanghua on 2017/5/25.
 */
public class customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String username;

    private String password;

    private String email;

    private String mobile;

    private String real_name;

    private String admin_flg;

    private String reg_time;

    private String update_time;

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public String getAdmin_flg() {
        return admin_flg;
    }

    public void setAdmin_flg(String admin_flg) {
        this.admin_flg = admin_flg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
