package com.app.Testing.Service;

import com.app.Testing.Entity.User;
import com.app.Testing.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public User findUser(String name){
        return userRepository.findById(name)
                .orElseThrow(()->new RuntimeException("User không tồn tại"));
    }
    public User register(User user){
        if(userRepository.existsById(user.getUsername()))
            throw new RuntimeException("User đã tồn tại");

        return userRepository.save(user);
    }

    public boolean login(User user){
        User userDB = userRepository.findById(user.getUsername())
                .orElseThrow(()->new RuntimeException("User không tồn tại"));

        if(!user.getPassword().equals(userDB.getPassword()))
                throw new RuntimeException("Sai mật khẩu ");

        return true;
    }


}
