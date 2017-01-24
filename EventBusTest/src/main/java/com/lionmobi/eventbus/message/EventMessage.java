package com.lionmobi.eventbus.message;

/**
 * Created by ChenR on 2017/1/24.
 */

public class EventMessage {

    private String message;

    public EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
