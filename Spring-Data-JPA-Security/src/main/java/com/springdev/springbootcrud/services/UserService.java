package com.springdev.springbootcrud.services;

import java.util.List;

import com.springdev.springbootcrud.domains.User;
import com.springdev.springbootcrud.exceptions.UsernameExistsException;

public interface UserService {

	User findById(Long userid);
	 
    User findByUsername(String username);

    void saveUser(User user) throws UsernameExistsException;
 
    void updateUser(User user) throws UsernameExistsException; 
 
    void deleteUserById(Long userid);
 
    void deleteAllUsers();
 
    List<User> findAllUsers();
 
    boolean isUserExist(User user);
	
}
