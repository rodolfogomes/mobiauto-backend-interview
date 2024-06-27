package com.rgomes.mobiauto_backend_interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rgomes.mobiauto_backend_interview.domain.User;
import com.rgomes.mobiauto_backend_interview.services.StoreService;


@Controller
public class StoreController {

  
    @Autowired
    private StoreService storeService;

    @PostMapping("/{storeId}/users")
    @PreAuthorize("hasRole('PROPRIETARIO') or hasRole('GERENTE')")
    public ResponseEntity<?> addUserToStore(@PathVariable Long storeId, @RequestBody User user) {
        return ResponseEntity.ok(storeService.addUserToStore(storeId, user));
    }

    @PutMapping("/{storeId}/users/{userId}")
    @PreAuthorize("hasRole('PROPRIETARIO')")
    public ResponseEntity<?> updateUserInStore(@PathVariable Long storeId, @PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(storeService.updateUserInStore(storeId, userId, user));
    }

    @DeleteMapping("/{storeId}/users/{userId}")
    @PreAuthorize("hasRole('PROPRIETARIO')")
    public ResponseEntity<?> removeUserFromStore(@PathVariable Long storeId, @PathVariable Long userId) {
        storeService.removeUserFromStore(storeId, userId);
        return ResponseEntity.noContent().build();
    }
    
}
