package com.gmfiot.office.model;

import com.gmfiot.core.model.BaseModel;

public class RolePermission extends BaseModel {
    private Long roleId;
    private  Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
