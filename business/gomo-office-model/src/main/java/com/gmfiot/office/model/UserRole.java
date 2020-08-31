package com.gmfiot.office.model;

import com.gmfiot.core.model.BaseModel;

/**
 * @author ThinkPad
 */
public class UserRole extends BaseModel {
    private Long roleId;
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
