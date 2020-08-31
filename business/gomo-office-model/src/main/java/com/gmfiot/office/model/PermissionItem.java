package com.gmfiot.office.model;

import com.gmfiot.core.model.BaseModel;

public class PermissionItem extends BaseModel {
    private Long permissionId;
    private String code;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
