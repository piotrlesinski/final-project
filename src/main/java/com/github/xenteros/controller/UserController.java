package com.github.xenteros.controller;

import com.github.xenteros.dto.UserDto;
import com.github.xenteros.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    public UserDto createUser(@RequestParam String email, @RequestParam String password) {
        return userService.createUser(email, password);
    }

    @GetMapping("/{uuid}/enable")
    public void enableUser(@PathVariable String uuid) {
        userService.enableUser(uuid);
    }
}
