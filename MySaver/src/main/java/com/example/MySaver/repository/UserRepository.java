package com.example.MySaver.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.MySaver.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
