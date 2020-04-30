/**
 * @作者 leokkzhang
 * @创建时间 2020/4/30 23:56
 */
package com.lin.missyou.service;

import com.lin.missyou.model.User;
import com.lin.missyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findFirstById(id);
    }
}
