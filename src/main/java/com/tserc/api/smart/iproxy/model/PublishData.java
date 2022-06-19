package com.tserc.api.smart.iproxy.model;

import java.util.Date;

public class PublishData {
    Date date;
    String data;

    public Date getDate() {
        return date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    String message;
}
