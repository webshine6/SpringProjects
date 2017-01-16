package com.springdev.springbootcrud.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdev.springbootcrud.domains.Role;
import com.springdev.springbootcrud.repositories.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public Role findById(Long roleid) {
		return roleRepository.getOne(roleid);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
