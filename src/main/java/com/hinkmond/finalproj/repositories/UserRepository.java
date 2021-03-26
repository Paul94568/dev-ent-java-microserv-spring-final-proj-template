package com.hinkmond.finalproj.repositories;

import com.hinkmond.finalproj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
