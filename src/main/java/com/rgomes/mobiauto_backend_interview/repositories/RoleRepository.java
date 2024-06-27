package com.rgomes.mobiauto_backend_interview.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgomes.mobiauto_backend_interview.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
