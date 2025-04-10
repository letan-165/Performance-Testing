package com.app.Testing.Service;

import com.app.Testing.Entity.User;
import com.app.Testing.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User register(User user){
        if(userRepository.existsById(user.getUsername()))
            throw new RuntimeException("User đã tồn tại");

        user.setLogin(false);
        return userRepository.save(user);
    }

    public boolean login(User user){
        User userDB = userRepository.findById(user.getUsername())
                .orElseThrow(()->new RuntimeException("User không tồn tại"));

        if(!user.getPassword().equals(userDB.getPassword()))
                throw new RuntimeException("Sai mật khẩu ");

        if(userDB.isLogin())
            throw new RuntimeException("Tài khoản đang đăng nhập");

        userDB.setLogin(true);
        userRepository.save(userDB);

        return true;
    }

    public boolean logout(String name){
        User user = userRepository.findById(name)
                .orElseThrow(()->new RuntimeException("User không tồn tại"));
        user.setLogin(false);
        userRepository.save(user);

        return true;
    }


    public void deleteAll(){
        userRepository.deleteAll();
    }


}
