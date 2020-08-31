package com.gmfiot.office.model;

import com.gmfiot.core.model.BaseModel;

public class UserCredential extends BaseModel {
    private String code;
    private String password;
    private Long userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
