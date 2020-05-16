package com.staxrt.tutorial.EventHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by ubuntu on 16/05/20.
 */
@Component
public class LoginFailureEventHandler implements ApplicationListener<LoginFailureEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(LoginFailureEventHandler.class);

    @Override
    public void onApplicationEvent(LoginFailureEvent loginFailureEvent) {
        LOG.info("user name {0}", loginFailureEvent.getSource());
    }
}
