package com.main.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.RepoCourseTeacher;
import com.main.repository.CourseTeacherRepository;
import com.main.service.CourseTeacherservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseTeacherSerImpl implements CourseTeacherservice {

  @Autowired private CourseTeacherRepository repository;

  @Override
  public Mono<RepoCourseTeacher> CreateRepocourseteacher(RepoCourseTeacher repocourse) {
    // TODO Auto-generated method stub
    return repository.save(repocourse);
  }

  @Override
  public Mono<Void> DeleteById(String id) {
    // TODO Auto-generated method stub
    return repository.deleteById(id);
  }

  @Override
  public Mono<RepoCourseTeacher> findById(String id) {
    // TODO Auto-generated method stub
    return repository.findById(id);
  }

  @Override
  public Flux<RepoCourseTeacher> findByIdteacher(String idteacher) {
    // TODO Auto-generated method stub
    return repository.findByIdteacher(idteacher);
  }

  @Override
  public Flux<RepoCourseTeacher> findByIdteacherAndCondition(String idteacher, String condition) {
    // TODO Auto-generated method stub
    return repository.findByIdteacherAndCondition(idteacher, condition);
  }

  @Override
  public Flux<RepoCourseTeacher> findByIdteacherAndStatus(String idteacher, String status) {
    // TODO Auto-generated method stub
    return repository.findByIdteacherAndStatus(idteacher, status);
  }

  @Override
  public Flux<RepoCourseTeacher> Getall() {
    // TODO Auto-generated method stub
    return repository.findAll();
  }

  @Override
  public Mono<RepoCourseTeacher> ModifyCourseTeacher(String id, RepoCourseTeacher repocourse) {
    // TODO Auto-generated method stub
    repocourse.setId(id);
    return repository.save(repocourse);
  }
}
