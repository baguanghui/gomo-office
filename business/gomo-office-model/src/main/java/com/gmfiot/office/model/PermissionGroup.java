package com.gmfiot.office.model;


import com.gmfiot.core.model.BaseModel;

/**
 * @author ThinkPad
 */
public class PermissionGroup extends BaseModel {
    private String name;
    private Boolean deletable;
    private Long businessSystemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Long getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(Long businessSystemId) {
        this.businessSystemId = businessSystemId;
    }
}
