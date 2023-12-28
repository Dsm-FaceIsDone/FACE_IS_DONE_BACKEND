package com.example.face_back.domain.skein.domain.repository;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.skein.domain.Skein;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SkeinRepository extends CrudRepository<Skein, Long> {
    Optional<Skein> findAllByPostOrderByIdDesc(Post post);
}
