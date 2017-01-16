package com.springdev.springbootcrud.services;

import java.util.List;

import com.springdev.springbootcrud.domains.Role;

public interface RoleService {

	Role findById(Long roleid);

	List<Role> findAll();
}
