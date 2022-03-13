package com.phonebook.frontend.controller;

import com.phonebook.frontend.client.BackendClient;
import com.phonebook.frontend.model.UserEntity;
import com.phonebook.frontend.model.UserOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final BackendClient backendClient;

    @GetMapping("/")
    public String listUsers(Model model) {
        List<UserEntity> users = backendClient.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("userEntity", new UserEntity());
        return "user.html";
    }

    @GetMapping("/status")
    public String getStatus(Model model) {
        List<UserEntity> users = backendClient.getStatus();
        model.addAttribute("users", users);
        model.addAttribute("userEntity", new UserEntity());
        return "user.html";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute UserEntity userEntity, Model model) {
        UserOperation userOperation = backendClient.postUser(userEntity);
        model.addAttribute("operation", userOperation);
        return "operation";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute UserEntity userEntity, Model model) {
        UserOperation userOperation = backendClient.editUser(userEntity);
        model.addAttribute("operation", userOperation);
        return "operation";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@ModelAttribute UserEntity userEntity, Model model) {
        UserOperation userOperation = backendClient.deleteUser(userEntity);
        model.addAttribute("operation", userOperation);
        return "operation";
    }
}
