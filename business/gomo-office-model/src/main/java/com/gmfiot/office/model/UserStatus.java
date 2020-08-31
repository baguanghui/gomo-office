package com.gmfiot.office.model;

import com.gmfiot.core.model.BaseModel;

/**
 * @author ThinkPad
 */
public class UserStatus extends BaseModel {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
