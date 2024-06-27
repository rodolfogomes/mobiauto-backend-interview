package com.rgomes.mobiauto_backend_interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgomes.mobiauto_backend_interview.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}
