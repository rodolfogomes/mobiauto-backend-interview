package com.rgomes.mobiauto_backend_interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rgomes.mobiauto_backend_interview.domain.Store;
import com.rgomes.mobiauto_backend_interview.domain.User;
import com.rgomes.mobiauto_backend_interview.services.StoreService;
import com.rgomes.mobiauto_backend_interview.services.UserService;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private StoreService storeService;

    @PostMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/stores")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createStore(@RequestBody @Validated Store store) {
        return ResponseEntity.ok(storeService.save(store));
    }

    public ResponseEntity<?> createUserForManagerAndOwners() {
        return ResponseEntity.ok(userService.createUserForManagerAndOwners());
    }

    @PutMapping("/users/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(userId, user));
    }

    @DeleteMapping("/users/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
    
}
