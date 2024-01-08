package com.example.face_back.domain.skein.presentation;

import com.example.face_back.domain.post.presentation.dto.response.ReturnIdResponse;
import com.example.face_back.domain.skein.presentation.dto.request.SkeinRequest;
import com.example.face_back.domain.skein.service.SkeinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/skein")
@RestController
@RequiredArgsConstructor
public class SkeinController {
    private final SkeinService skeinService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReturnIdResponse create(@RequestBody @Valid SkeinRequest request) {
        return skeinService.creat(request);
    }
    @PostMapping(value = "/skeinImage/{id}", consumes = "multipart/form-data")
    public void skeinImage(@PathVariable @NotNull Long id, @RequestPart(value = "image") MultipartFile file) {
        skeinService.skeinImage(id, file);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull Long id) {
        skeinService.delete(id);
    }
}
