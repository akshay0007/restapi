package com.staxrt.tutorial.EventHandling;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by ubuntu on 16/05/20.
 */
@Component
public class LoginFailureEventPub implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher appPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.appPublisher=applicationEventPublisher;
    }

    public void publishEvent(LoginFailureEvent loginFailureEvent){
        appPublisher.publishEvent(loginFailureEvent);
    }
}
