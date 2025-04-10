package com.app.Testing.Controller;

import com.app.Testing.Entity.User;
import com.app.Testing.Service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/findAll")
    List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/register")
    User register(@RequestBody User user){
        return userService.register(user);
    }

    @PutMapping("/login")
    boolean login(@RequestBody User user){
        return userService.login(user);
    }

    @PutMapping("/logout/{name}")
    boolean logout(@PathVariable String name){
        return userService.logout(name);
    }

    @DeleteMapping("/deleteAll")
    void deleteAll(){
        userService.deleteAll();
    }
}
