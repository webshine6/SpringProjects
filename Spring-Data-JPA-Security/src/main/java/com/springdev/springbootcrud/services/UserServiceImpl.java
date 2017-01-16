package com.springdev.springbootcrud.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springdev.springbootcrud.domains.User;
import com.springdev.springbootcrud.repositories.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findById(Long userid) {
		return userRepository.findOne(userid);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(user.getRoles());
		userRepository.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		saveUser(user);		
	}

	@Override
	public void deleteUserById(Long userid) {
		userRepository.delete(userid);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();		
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		return findById(user.getUserid()) != null;
	}

}
