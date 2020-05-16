package com.staxrt.tutorial.services;

import com.staxrt.tutorial.daos.EncryptUserDao;
import com.staxrt.tutorial.model.SecureUser;
import com.staxrt.tutorial.securities.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ubuntu on 15/05/20.
 */
@Service
public class EncryptUserService {

    EncryptionService encryptionService;

    EncryptUserDao encryptUserDao;

    @Autowired
    @Qualifier("encryptionServiceImpl")
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Autowired
    @Qualifier("encryptUserDaoImpl")
    public void setEncryptUserDao(EncryptUserDao encryptUserDao) {
        this.encryptUserDao = encryptUserDao;
    }


    public SecureUser findById(Integer id) {
        return (SecureUser) encryptUserDao.findById(id);
    }

    public List<SecureUser> getAll() {
        return encryptUserDao.getAll();
    }

    public void delete(Integer id) {
        encryptUserDao.delete(id);
    }

    public SecureUser create(SecureUser secureUser) {
        secureUser.setEncryptedPass(encryptionService.encryptPassword(secureUser.getPassword()));
        return (SecureUser) encryptUserDao.create(secureUser);
    }

    public void put(SecureUser secureUser) {
        encryptUserDao.put(secureUser);
    }

    public SecureUser findByUserName(String userName) {
        return (SecureUser) encryptUserDao.findByUserName(userName);

    }


}
