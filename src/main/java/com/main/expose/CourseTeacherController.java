package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.main.model.RepoCourseTeacher;
import com.main.service.CourseTeacherservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/Reporte2")
public class CourseTeacherController {

		@Autowired
	    private CourseTeacherservice reposervice;

	    @GetMapping
	    public Flux<RepoCourseTeacher> Getall() {
	        return reposervice.Getall();
	    }
	    
	    @GetMapping("/findteacher/{idteacher}")
	    public Flux<RepoCourseTeacher> FindbyIdteacher(@PathVariable String idteacher) {
	        return reposervice.findByIdteacher(idteacher);
	    }

	    @GetMapping("/coursestatus/{idteacher}/{status}")
	    public Flux<RepoCourseTeacher> FindbyIdteacherAndStatus(@PathVariable String idteacher,
	            @PathVariable String status) {
	        return reposervice.findByIdteacherAndStatus(idteacher,status);
	    }

	    @GetMapping("/coursecondition/{idteacher}/{condition}")
	    public Flux<RepoCourseTeacher> FindbyIdteacherAndCondition(@PathVariable String idteacher,
	            @PathVariable String condition) {
	        return reposervice.findByIdteacherAndCondition(idteacher, condition);
	    }

	    @PostMapping("/create")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Mono<RepoCourseTeacher> createCourseStudents(@RequestBody RepoCourseTeacher repocourse) {
	        return reposervice.CreateRepocourseteacher(repocourse);
	    }

	    @PutMapping("/update/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Mono<RepoCourseTeacher> updateCourseStudents(@PathVariable String id,
	            @RequestBody RepoCourseTeacher repocourse) {
	        return reposervice.ModifyCourseTeacher(id, repocourse);
	    }

	    @DeleteMapping("/delete/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public Mono<Void> deleteCourseStudents(@PathVariable String id) {
	        return reposervice.DeleteById(id);
	    }
}
