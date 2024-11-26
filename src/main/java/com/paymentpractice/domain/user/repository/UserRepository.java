package com.paymentpractice.domain.user.repository;

import com.paymentpractice.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
