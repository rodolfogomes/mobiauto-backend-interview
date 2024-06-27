package com.rgomes.mobiauto_backend_interview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgomes.mobiauto_backend_interview.domain.Store;
import com.rgomes.mobiauto_backend_interview.domain.User;
import com.rgomes.mobiauto_backend_interview.repositories.StoreRepository;
import com.rgomes.mobiauto_backend_interview.repositories.UserRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    public Store save(Store store) {
        return storeRepository.save(store);
    }

    public Store addUserToStore(Long storeId, User user) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        user.getStores().add(store);
        userRepository.save(user);
        return store;
    }

    public Store updateUserInStore(Long storeId, Long userId, User user) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Update user details
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Save updated user
        userRepository.save(existingUser);
        return store;
    }

    public void removeUserFromStore(Long storeId, Long userId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getStores().remove(store);
        userRepository.save(user);
    }
    
}
