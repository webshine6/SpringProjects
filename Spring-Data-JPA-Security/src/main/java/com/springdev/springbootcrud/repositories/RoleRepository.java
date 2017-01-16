package com.springdev.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdev.springbootcrud.domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
