package com.api.products.dao;

import com.api.products.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepository extends JpaRepository<User,Long> {
     User findByUsername(String username);
}
