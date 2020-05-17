package com.staxrt.tutorial.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by ubuntu on 16/05/20.
 */
//no needs to add any annoation when context got refresh added into bean
@Component
public class CommonDBBean implements ApplicationListener<ContextRefreshedEvent> {

//    EncryptUserService encryptUserService;

    //
//    //autowired without autowire new feature in spring but in setter required autowired
//    public CommonDBBean(EncryptUserService encryptUserService) {
//        this.encryptUserService = encryptUserService;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //crate bean and stored it
        initData();
    }

    private void initData() {
//        for (int i = 0; i < 100; i++) {
//        SecureUser secureUser = new SecureUser();
//            secureUser.setPassword("username" + i);
//            secureUser.setPassword("pass" + i);
//            Role role = new Role();
//            role.setRole("admin");
//            secureUser.setRoleLists(role);
//            encryptUserService.create(secureUser);
//        }
    }
}
