package com.hrsystem.usermanagement.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hrsystem.usermanagement.model.Role;
import com.hrsystem.usermanagement.model.RoleName;

@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Optional<Role> findByName(RoleName roleName);
}
