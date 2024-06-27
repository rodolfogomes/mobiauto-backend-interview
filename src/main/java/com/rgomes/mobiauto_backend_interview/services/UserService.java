package com.rgomes.mobiauto_backend_interview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rgomes.mobiauto_backend_interview.domain.User;
import com.rgomes.mobiauto_backend_interview.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(Long userId, User user) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Update other fields as necessary
        return userRepository.save(existingUser);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public Object createUserForManagerAndOwners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUserForManagerAndOwners'");
    }
}
