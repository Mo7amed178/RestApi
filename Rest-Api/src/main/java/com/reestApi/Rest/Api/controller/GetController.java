package com.reestApi.Rest.Api.controller;

import com.reestApi.Rest.Api.Model.Comments;
import com.reestApi.Rest.Api.Model.FindPostByUserId;
import com.reestApi.Rest.Api.Model.Posts;
import com.reestApi.Rest.Api.Model.Users;
import com.reestApi.Rest.Api.Service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class GetController {

    private final Service service;

    public GetController(Service service) {
        this.service = service;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Users>> getAllUsers()
    {
     List<Users> res = service.getAllUsers();
     return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<List<Posts>> getAllPosts()
    {
        List<Posts> res = service.getAllPosts();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<List<Comments>> getAllComments()
    {
        List<Comments> res = service.getAllComments();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/Posts/findPostByUserId")
    public ResponseEntity<Optional<Posts>> findPostByUserId(@RequestBody @Valid FindPostByUserId findPostByUserId)
    {
        Optional<Posts> res = service.getPostByUserId(findPostByUserId.getUserId());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/Comments/{postId}")
    public ResponseEntity<Optional<Comments>> findPostByPostId(@PathVariable("postId") @Valid String postId)
    {
        Optional<Comments> res = service.getPostByPostId(postId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
