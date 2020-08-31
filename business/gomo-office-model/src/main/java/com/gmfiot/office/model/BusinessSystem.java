package com.gmfiot.office.model;

import com.gmfiot.core.model.AbstractModel;

import java.util.Date;

/**
 * @author ThinkPad
 */
public class BusinessSystem extends AbstractModel {
    private String code;
    private String name;
    private Boolean isEnabled;
    private String systemMaintenancedImage;
    private Boolean isSystemMaintenanced;
    private Date systemMaintenancedFrom;
    private Date systemMaintenancedTo;
    private String systemMaintenancedWebUrl;
    private String systemMaintenancedH5Url;
    private String downloadDomainName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getSystemMaintenancedImage() {
        return systemMaintenancedImage;
    }

    public void setSystemMaintenancedImage(String systemMaintenancedImage) {
        this.systemMaintenancedImage = systemMaintenancedImage;
    }

    public Boolean getSystemMaintenanced() {
        return isSystemMaintenanced;
    }

    public void setSystemMaintenanced(Boolean systemMaintenanced) {
        isSystemMaintenanced = systemMaintenanced;
    }

    public Date getSystemMaintenancedFrom() {
        return systemMaintenancedFrom;
    }

    public void setSystemMaintenancedFrom(Date systemMaintenancedFrom) {
        this.systemMaintenancedFrom = systemMaintenancedFrom;
    }

    public Date getSystemMaintenancedTo() {
        return systemMaintenancedTo;
    }

    public void setSystemMaintenancedTo(Date systemMaintenancedTo) {
        this.systemMaintenancedTo = systemMaintenancedTo;
    }

    public String getSystemMaintenancedWebUrl() {
        return systemMaintenancedWebUrl;
    }

    public void setSystemMaintenancedWebUrl(String systemMaintenancedWebUrl) {
        this.systemMaintenancedWebUrl = systemMaintenancedWebUrl;
    }

    public String getSystemMaintenancedH5Url() {
        return systemMaintenancedH5Url;
    }

    public void setSystemMaintenancedH5Url(String systemMaintenancedH5Url) {
        this.systemMaintenancedH5Url = systemMaintenancedH5Url;
    }

    public String getDownloadDomainName() {
        return downloadDomainName;
    }

    public void setDownloadDomainName(String downloadDomainName) {
        this.downloadDomainName = downloadDomainName;
    }
}
