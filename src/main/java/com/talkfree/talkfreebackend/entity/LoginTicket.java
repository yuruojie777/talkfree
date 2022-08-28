package com.talkfree.talkfreebackend.entity;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class LoginTicket {

    @Id
    private String sessionId;
    private String userId;
    private Timestamp loginTime;
    private String devices;

    public LoginTicket(String sessionId, String userId, Timestamp loginTime, String devices) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.devices = devices;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }


    @Override
    public String toString() {
        return "LoginTicket{" +
                "sessionId='" + sessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", loginTime=" + loginTime +
                ", devices='" + devices + '\'' +
                '}';
    }
}
