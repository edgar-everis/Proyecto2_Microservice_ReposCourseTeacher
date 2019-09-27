package com.main.expose;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.main.model.RepoCourseTeacher;

import com.main.repository.CourseTeacherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class CourseTeacherControllerTest {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CourseTeacherRepository Repository;
    private WebTestClient client;
    private List<RepoCourseTeacher> expectedProducts;
  @BeforeEach
  void setUp() throws Exception {
      client = WebTestClient
	      .bindToApplicationContext(applicationContext)
	      .configureClient()
	      .baseUrl("/API/RepoCourseTeachers")
	      .build();

	    Flux<RepoCourseTeacher> initData = Repository.deleteAll()
	      .thenMany(Flux.just(
	RepoCourseTeacher.builder().id("1").idcourse("C01").idteacher("PR01").status("Activo").condition("Iniciado").build(),
	RepoCourseTeacher.builder().id("2").idcourse("C02").idteacher("PR02").status("Activo").condition("Iniciado").build())
	        .flatMap(Repository::save))
	      .thenMany(Repository.findAll());

	    expectedProducts = initData.collectList().block();
  }

  @Test
  void testCreateCourseTeachers() {
      RepoCourseTeacher expectedProduct = expectedProducts.get(0);
      client.post().uri("/create").body(Mono.just(expectedProduct), RepoCourseTeacher.class).exchange()
        .expectStatus().isCreated();
  }

  @Test
  void testDeleteCourseTeachers() {
      RepoCourseTeacher productToDelete = expectedProducts.get(0);
      client.delete().uri("/delete/{id}", productToDelete.getId()).exchange()
        .expectStatus().isNoContent();
  }

  @Test
  void testFindbyIdteacher() {
      String idteacher = "jose";
      client.get().uri("/findteacher/{idteacher}", idteacher).exchange()
        .expectStatus().isOk();
  }

  @Test
  void testFindbyIdteacherAndCondition() {
    
      String idteacher = "PR01";
      String condition = "Iniciado";


        client.get().uri("/coursecondition/{idteacher}/{condition}", idteacher,condition).exchange()
          .expectStatus().isOk().
      expectBodyList(RepoCourseTeacher.class);
  }

  @Test
  void testFindbyIdteacherAndStatus() {
      String idteacher = "PR01";
      String status = "Activo";


        client.get().uri("/coursestatus/{idteacher}/{status}", idteacher,status).exchange()
          .expectStatus().isOk().
      expectBodyList(RepoCourseTeacher.class);
  }

  @Test
  void testGetall() {
      client.get().uri("/").exchange()
      .expectStatus().isOk();
  }

  @Test
  void testUpdateCourseTeachers() {
      RepoCourseTeacher expectedProduct = expectedProducts.get(0);

      client.put().uri("/update/{id}", expectedProduct.getId()).body(Mono.just(expectedProduct), RepoCourseTeacher.class).exchange()
        .expectStatus().isOk();
  }
}
