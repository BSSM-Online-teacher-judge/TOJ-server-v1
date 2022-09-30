package com.toj.teacheronlinejudge.domain.teacher.presentation;

import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.TeacherRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherRankingResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public void createTeacher(@RequestBody @Valid TeacherRequestDto dto) {
        teacherService.createTeacher(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public void updateTeacher(
            @PathVariable Long id,
            @RequestBody TeacherRequestDto dto
    ) {
        teacherService.updateTeacher(id, dto);
    }

    @GetMapping
    public List<TeacherResponseDto> findTeacherList() {
        return teacherService.findTeacherList();
    }

    @GetMapping("/{id}")
    public TeacherResponseDto findTeacherDetail(@PathVariable Long id) {
        return teacherService.findTeacherDetail(id);
    }

    @GetMapping("/ranking")
    public List<TeacherRankingResponseDto> findTeacherRanking() {
        return teacherService.findTeacherRanking();
    }
}
