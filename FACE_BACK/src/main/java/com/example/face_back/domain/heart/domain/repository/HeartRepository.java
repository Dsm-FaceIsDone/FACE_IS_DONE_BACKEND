package com.example.face_back.domain.heart.domain.repository;

import com.example.face_back.domain.heart.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
}
