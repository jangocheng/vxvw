package com.snax.vxvw.vxvwwx.dao;

import java.time.LocalDateTime;

public class UserToken {
    private Integer userId;
    private String token;
    private String sessionKey;
    private LocalDateTime expireTime;
    private LocalDateTime updateTime;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
}
