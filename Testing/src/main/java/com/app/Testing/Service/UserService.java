package com.app.Testing.Service;

import com.app.Testing.Entity.User;
import com.app.Testing.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;

    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        log.info("Check size list:{}",users.size());
        return users;
    }

    public User register(User user){
        if(userRepository.existsById(user.getUsername()))
            throw new RuntimeException("User đã tồn tại");

        return userRepository.save(user);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }


}
