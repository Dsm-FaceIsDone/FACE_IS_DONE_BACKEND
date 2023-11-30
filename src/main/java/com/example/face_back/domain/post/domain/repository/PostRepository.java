package com.example.face_back.domain.post.domain.repository;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    long countByUser(User user);
}
