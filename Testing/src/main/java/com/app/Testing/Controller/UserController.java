package com.app.Testing.Controller;

import com.app.Testing.Entity.User;
import com.app.Testing.Service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/find/{name}")
    User findUser(@PathVariable String name){
        return userService.findUser(name);
    }

    @PostMapping("/register")
    User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    boolean login(@RequestBody User user){
        return userService.login(user);
    }
}
