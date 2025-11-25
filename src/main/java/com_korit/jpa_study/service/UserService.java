package com_korit.jpa_study.service;


import com_korit.jpa_study.dto.AddUserReqDto;
import com_korit.jpa_study.dto.ApiRespDto;
import com_korit.jpa_study.entity.User;
import com_korit.jpa_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ApiRespDto<?> addUser(AddUserReqDto addUserReqDto) {
        Optional<User> foundUser = userRepository.findUserByUsername(addUserReqDto.getUsername());

        if (foundUser.isPresent()) {
            return new ApiRespDto<>("failed", "중복된 username", addUserReqDto.getUsername());
        }
    }
}
