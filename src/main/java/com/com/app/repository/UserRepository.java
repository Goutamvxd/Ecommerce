package com.com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.com.app.entitiy.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
