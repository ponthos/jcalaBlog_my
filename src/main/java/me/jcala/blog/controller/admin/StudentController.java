package me.jcala.blog.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@Api
@RestController
@RequestMapping("/api/Student")
public class StudentController {
//    private StudentController studentController;
//
//    @Autowired
//    public StudentController(StudentController studentController) {
//        this.studentController = studentController;
//    }

    @GetMapping()
    public String Get() {
        return "{\"id\":\"1\",\"name\":\"1111111111\"}";
    }

    @PostMapping()
    public String Post() {
        return "{\"id\":\"2\",\"name\":\"2222222222\"}";
    }

    @PutMapping()
    public String Put() {
        return "{\"id\":\"3\",\"name\":\"3333333333\"}";
    }

    @DeleteMapping()
    public String DELETE() {
        return "{\"id\":\"4\",\"name\":\"4444444444\"}";
    }

    @GetMapping(value = "/{id}")
    public String Get(@PathVariable("id") Integer id) {
        return "{\"id\":\"" + id + "\",\"name\":\"get path variable id\"}";
    }
}