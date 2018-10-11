package com.study.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserId(String userId);
}
