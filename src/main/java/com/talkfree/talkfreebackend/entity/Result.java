package com.talkfree.talkfreebackend.entity;

public class Result {

    private String message;
    private int stateCode;

    public Result(String message, int stateCode) {
        this.message = message;
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                ", stateCode=" + stateCode +
                '}';
    }
}
