package com.example.face_back.domain.post.presentation;

import com.example.face_back.domain.heart.presentation.dto.HeartResponse;
import com.example.face_back.domain.heart.service.CreateHeartService;
import com.example.face_back.domain.heart.service.DeleteHeartService;
import com.example.face_back.domain.post.presentation.dto.request.PostRequest;
import com.example.face_back.domain.post.presentation.dto.response.PostListResponse;
import com.example.face_back.domain.post.presentation.dto.response.PostResponse;
import com.example.face_back.domain.post.presentation.dto.response.ReturnIdResponse;
import com.example.face_back.domain.post.service.PostDetailsService;
import com.example.face_back.domain.post.service.PostListService;
import com.example.face_back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostListService postListService;
    private final PostDetailsService postDetailsService;
    private final CreateHeartService createHeartService;
    private final DeleteHeartService deleteHeartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReturnIdResponse create (@RequestBody @Valid PostRequest request) {
        return postService.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull Long id) {
        postService.delete(id);
    }

    @GetMapping("/{id}")
    public PostResponse getPostDetails(@PathVariable @NotNull Long id) {
        return postDetailsService.getPostDetails(id);
    }

    @PostMapping(value = "/postImage/{id}", consumes = "multipart/form-data")
    public void postImage(@PathVariable @NotNull Long id, @RequestPart(value = "image") MultipartFile file) {
        postService.postImage(id, file);
    }

    @GetMapping("/user")
    public PostListResponse getUserPostsPaged(Pageable pageable) {
        return postListService.getUserPostsPaged(pageable);
    }

    @GetMapping("/search")
    public PostListResponse findPost(@RequestParam(value = "content") String content, Pageable page) {
        return postListService.findPost(content, page);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/heart/{id}")
    public HeartResponse heart(@PathVariable Long id) {
        return createHeartService.createHeart(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/heart/{id}")
    public HeartResponse deleteHeart(@PathVariable Long id) {
        return deleteHeartService.deleteHeart(id);
    }
}
