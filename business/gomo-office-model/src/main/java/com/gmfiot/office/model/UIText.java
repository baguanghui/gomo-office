package com.gmfiot.office.model;

import com.gmfiot.core.model.AbstractModel;

import java.util.Date;

/**
 * @author ThinkPad
 */
public class UIText extends AbstractModel {
    private String code;
    private String content;
    private String language;
    private String country;
    private String module;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

}
