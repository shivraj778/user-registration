package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {

   UserDetails findByEmail(String email);
}
