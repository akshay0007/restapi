package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.model.SecureUser;
import com.staxrt.tutorial.services.EncryptUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.time.Duration;
import java.util.List;

/**
 * Created by ubuntu on 16/05/20.
 */
@RestController
@RequestMapping("/secure")
public class SecureUserController {

    EncryptUserService encryptUserService;

    public SecureUserController(EncryptUserService encryptUserService) {
        this.encryptUserService = encryptUserService;
    }

    @GetMapping(value = "/fluxAll",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getAllF() {
        return Flux.just("abc", "cde", "es1","es2","es3","es4","es5","es35")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }


    @GetMapping("/getAll")
    ResponseEntity<List<?>> getAll() {
        return ResponseEntity.ok().body(encryptUserService.getAll());
    }


    @PostMapping("/add")
    ResponseEntity<?> create(@RequestBody SecureUser secureUser) {
        SecureUser se = encryptUserService.create(secureUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encryptUserService.findById(se.getID()))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/{userId}")
    ResponseEntity<?> findOne(Integer id) {
        return ResponseEntity.ok().body(encryptUserService.findById(id));
    }
}
