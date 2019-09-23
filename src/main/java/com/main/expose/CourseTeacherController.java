package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.RepoCourseTeacher;
import com.main.service.CourseTeacherservice;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/API/Reporte2")
public class CourseTeacherController {

		@Autowired
	    private CourseTeacherservice reposervice;

	    @GetMapping
	    public Flux<RepoCourseTeacher> Getall() {
	        return reposervice.Getall();
	    }
}
