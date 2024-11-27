package com.paymentpractice.domain.user.service;

import com.paymentpractice.domain.user.model.User;
import com.paymentpractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User UserRegister() {
        User user = User.builder()
                .name(UUID.randomUUID().toString())
                .email("example@gmail.com")
                .address("한국 서울특별시 코딩동")
                .build();
        return userRepository.save(user);
    }
}