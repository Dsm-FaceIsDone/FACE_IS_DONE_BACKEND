package com.example.face_back.domain.user.domain.repository;

import com.example.face_back.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
