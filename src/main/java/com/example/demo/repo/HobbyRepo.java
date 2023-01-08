package com.example.demo.repo;

import com.example.demo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hobby;

@Repository
public interface HobbyRepo extends JpaRepository<Hobby, String> {
    Hobby findByEmail(String email);
}
