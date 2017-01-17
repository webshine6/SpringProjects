package com.springdev.springbootcrud.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springdev.springbootcrud.domains.User;
import com.springdev.springbootcrud.exceptions.UsernameExistsException;
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
	public void saveUser(User user) throws UsernameExistsException {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(user.getRoles());
		
		if (usernameExists(user.getUsername())) {
			throw new UsernameExistsException("There is an user with this username: " + user.getUsername());
		}

		userRepository.save(user);		
	}

	@Override
	public void updateUser(User user) throws UsernameExistsException {
		if (usernameExists(user.getUsername())) {
			throw new UsernameExistsException("There is an user with this username: " + user.getUsername());
		}
		
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
		return findByUsername(user.getUsername()) != null;
	}
	
	private boolean usernameExists(String username) {
		
		User user = userRepository.findByUsername(username);
		
		if (user != null) {
			return true;
		}		
		return false;
	}
	

}
