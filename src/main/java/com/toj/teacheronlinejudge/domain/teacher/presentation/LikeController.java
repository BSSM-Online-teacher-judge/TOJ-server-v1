package com.toj.teacheronlinejudge.domain.teacher.presentation;

import com.toj.teacheronlinejudge.domain.teacher.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/like/{teacherId}")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public void createLike(@PathVariable Long teacherId) {
        likeService.createLike(teacherId);
    }

    @DeleteMapping
    public void removeLike(@PathVariable Long teacherId) {
        likeService.removeLike(teacherId);
    }
}
