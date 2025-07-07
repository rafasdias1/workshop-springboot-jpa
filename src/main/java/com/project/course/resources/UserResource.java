package com.project.course.resources;


import com.project.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user= new User(1L,"Maria","maria@gmail.com","932928261","12345");
        return ResponseEntity.ok().body(user);
    }
}
