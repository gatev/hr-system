package com.hrsystem.usermanagement.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hrsystem.usermanagement.model.Role;
import com.hrsystem.usermanagement.model.RoleName;
import com.hrsystem.usermanagement.service.BaseService;

@Repository
public interface RoleService extends BaseService<Role>{
    Optional<Role> findByName(RoleName roleName);
}
