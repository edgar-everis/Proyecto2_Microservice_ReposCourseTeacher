package com.main.serviceImplement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.RepoCourseTeacher;

import com.main.repository.CourseTeacherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CourseTeacherSerImplTest {

  @Mock private CourseTeacherRepository Repository;
  @InjectMocks private CourseTeacherSerImpl Service;

  @Test
  public void testCreateRepocourseteacher() {

    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.save(repo)).thenReturn(Mono.just(repo));
    Mono<RepoCourseTeacher> actual = Service.CreateRepocourseteacher(repo);
    assertResults(actual, repo);
  }

  @Test
  public void testDeleteById() {

    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");
    when(Repository.delete(repo)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {

    RepoCourseTeacher stu = new RepoCourseTeacher();
    stu.setId("4");
    stu.setIdcourse("C01");
    stu.setIdteacher("P01");
    stu.setStatus("iniciado");
    stu.setCondition("Activo");

    when(Repository.findById("4")).thenReturn(Mono.just(stu));
    Mono<RepoCourseTeacher> actual = Service.findById("4");
    assertResults(actual, stu);
    System.out.println(actual);
    System.out.println(stu.getIdcourse());
  }

  @Test
  public void testFindByIdteacher() {
    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("4");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdteacher("P01")).thenReturn(Flux.just(repo));
    Flux<RepoCourseTeacher> actual = Service.findByIdteacher("P01");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdteacher());
  }

  @Test
  public void testFindByIdteacherAndCondition() {
    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("4");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdteacherAndCondition("P01", "Activo")).thenReturn(Flux.just(repo));
    Flux<RepoCourseTeacher> actual = Service.findByIdteacherAndCondition("P01", "Activo");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdteacher());
  }

  @Test
  public void testFindByIdteacherAndStatus() {
    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("4");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setStatus("iniciado");
    repo.setCondition("Activo");

    when(Repository.findByIdteacherAndStatus("P01", "iniciado")).thenReturn(Flux.just(repo));
    Flux<RepoCourseTeacher> actual = Service.findByIdteacherAndStatus("P01", "iniciado");
    assertResults(actual, repo);
    System.out.println(actual);
    System.out.println(repo.getIdteacher());
  }

  @Test
  public void testGetall() {

    RepoCourseTeacher repo = new RepoCourseTeacher();
    repo.setId("1");
    repo.setIdcourse("C01");
    repo.setIdteacher("P01");
    repo.setCondition("Activo");
    repo.setStatus("Activo");
    when(Service.Getall()).thenReturn(Flux.just(repo));
    Flux<RepoCourseTeacher> actual = Service.Getall();
    assertResults(actual, repo);
  }

  private void assertResults(
      Publisher<RepoCourseTeacher> publisher, RepoCourseTeacher... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }
}
