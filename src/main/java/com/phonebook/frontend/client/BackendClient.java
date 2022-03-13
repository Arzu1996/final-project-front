package com.phonebook.frontend.client;

import com.phonebook.frontend.model.UserEntity;
import com.phonebook.frontend.model.UserOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "backend", url = "${endpoints.backend}")
public interface BackendClient {

    @GetMapping(value = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserEntity> getStatus();

    @GetMapping(value = "/user/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserEntity> getAllUsers();

    @PostMapping(value = "/user/add",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserOperation postUser(@RequestBody UserEntity userEntity);

    @PutMapping(value = "/user/edit",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserOperation editUser(@RequestBody UserEntity userEntity);

    @DeleteMapping(value = "/user/delete",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UserOperation deleteUser(@RequestBody UserEntity userEntity);

}

