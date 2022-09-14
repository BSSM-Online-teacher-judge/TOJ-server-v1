package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @InjectMocks 
    private TeacherService teacherService;

    @Mock
    private TeacherFacade teacherFacade;
    
    @Mock 
    private TeacherRepository teacherRepository;
    
    @Test
    @DisplayName("선생님 생성")
    void givenNothing_whenCreateTeacher_thenCreateTeacher() {
        
    }
}