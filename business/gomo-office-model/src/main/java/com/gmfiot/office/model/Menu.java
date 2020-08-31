package com.gmfiot.office.model;


import com.gmfiot.core.model.BaseModel;

public class Menu extends BaseModel {
    private Long parentId;
    private String name;
    private String url;
    private Long permissionId;
    private Long businessSystemId;
    private Long sort;
    private String icon;
    private Boolean deletable;
    private Boolean isDashboard;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(Long businessSystemId) {
        this.businessSystemId = businessSystemId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Boolean getDashboard() {
        return isDashboard;
    }

    public void setDashboard(Boolean dashboard) {
        isDashboard = dashboard;
    }
}
