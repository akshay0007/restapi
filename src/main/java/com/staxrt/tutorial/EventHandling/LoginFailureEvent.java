package com.staxrt.tutorial.EventHandling;

import org.springframework.context.ApplicationEvent;

/**
 * Created by ubuntu on 16/05/20.
 */
public class LoginFailureEvent  extends ApplicationEvent{
    public LoginFailureEvent(Object source) {
        super(source);
    }
}
