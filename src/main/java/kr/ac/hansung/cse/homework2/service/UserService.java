package kr.ac.hansung.cse.homework2.service;

import kr.ac.hansung.cse.homework2.entity.MyUser;
import kr.ac.hansung.cse.homework2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<MyUser> userList() {
        return userRepository.findAll();
    }
}
