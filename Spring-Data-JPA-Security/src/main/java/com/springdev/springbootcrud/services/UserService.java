package com.springdev.springbootcrud.services;

import java.util.List;

import com.springdev.springbootcrud.domains.User;

public interface UserService {

	User findById(Long userid);
	 
    User findByUsername(String username);

    void saveUser(User user);
 
    void updateUser(User user);
 
    void deleteUserById(Long userid);
 
    void deleteAllUsers();
 
    List<User> findAllUsers();
 
    boolean isUserExist(User user);
	
}
