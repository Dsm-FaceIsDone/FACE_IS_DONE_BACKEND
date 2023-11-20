package com.example.face_back.domain.post.domain.repository;

import com.example.face_back.domain.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    
}
