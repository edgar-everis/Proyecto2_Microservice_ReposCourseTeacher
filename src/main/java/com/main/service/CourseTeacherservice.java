package com.main.service;

import com.main.model.RepoCourseTeacher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseTeacherservice {

  Mono<RepoCourseTeacher> CreateRepocourseteacher(RepoCourseTeacher repocourse);

  Mono<Void> DeleteById(String id);

  Mono<RepoCourseTeacher> findById(String id);

  Flux<RepoCourseTeacher> findByIdteacher(String idteacher);

  Flux<RepoCourseTeacher> findByIdteacherAndCondition(String idteacher, String condition);

  Flux<RepoCourseTeacher> findByIdteacherAndStatus(String idteacher, String status);

  Flux<RepoCourseTeacher> Getall();

  Mono<RepoCourseTeacher> ModifyCourseTeacher(String id, RepoCourseTeacher repocourse);
}
