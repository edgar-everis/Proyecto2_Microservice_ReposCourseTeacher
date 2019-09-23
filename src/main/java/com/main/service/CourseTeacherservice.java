package com.main.service;

import org.springframework.stereotype.Service;


import com.main.model.RepoCourseTeacher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CourseTeacherservice {

	Flux<RepoCourseTeacher> findByIdteacherAndCondition(String idteacher, String condition);

    Flux<RepoCourseTeacher> findByIdteacherAndStatus(String idteacher, String status);

    Flux<RepoCourseTeacher> findByIdteacher(String idteacher);
    
    Flux<RepoCourseTeacher> Getall();
    
    Mono<RepoCourseTeacher> findById(String id);

    Mono<RepoCourseTeacher> CreateRepocourseteacher(RepoCourseTeacher repocourse);

    Mono<RepoCourseTeacher> ModifyCourseTeacher(String id, RepoCourseTeacher repocourse);

    Mono<Void> DeleteById(String id);
}
