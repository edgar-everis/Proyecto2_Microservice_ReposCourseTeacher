package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.RepoCourseTeacher;

import reactor.core.publisher.Flux;

@Repository
public interface CourseTeacherRepository
    extends ReactiveMongoRepository<RepoCourseTeacher, String> {

  Flux<RepoCourseTeacher> findByIdteacher(String idteacher);

  Flux<RepoCourseTeacher> findByIdteacherAndCondition(String idteacher, String condition);

  Flux<RepoCourseTeacher> findByIdteacherAndStatus(String idteacher, String status);
}
