package com.rgomes.mobiauto_backend_interview.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.rgomes.mobiauto_backend_interview.domain.User;
 import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
