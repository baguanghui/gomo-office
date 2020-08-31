package com.gmfiot.office.model;

import com.gmfiot.core.model.AbstractModel;

import java.util.Date;

/**
 * @author ThinkPad
 */
public class UserSession extends AbstractModel {
    private Long userId;
    private String sessionId;
    private Date expiredAt;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

}
