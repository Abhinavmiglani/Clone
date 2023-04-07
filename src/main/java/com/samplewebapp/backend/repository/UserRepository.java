package com.samplewebapp.backend.repository;

import com.samplewebapp.backend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser,Long> {
}
