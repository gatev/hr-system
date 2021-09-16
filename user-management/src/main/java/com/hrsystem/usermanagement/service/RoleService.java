package com.hrsystem.usermanagement.service;

import java.util.Optional;

import com.hrsystem.usermanagement.model.Role;
import com.hrsystem.usermanagement.model.RoleName;

public interface RoleService extends BaseService<Role>{
    Optional<Role> findByName(RoleName roleName);
}
