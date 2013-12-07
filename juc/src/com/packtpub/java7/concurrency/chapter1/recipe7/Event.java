package com.packtpub.java7.concurrency.chapter1.recipe7;

import java.util.Date;

/**
 * User: guorui
 * Date: 13-12-6
 * Time: 16:52
 */
public class Event {

    /**
     * Date of the event
     */
    private Date date;

    /**
     * Message of the event
     */
    private String event;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
