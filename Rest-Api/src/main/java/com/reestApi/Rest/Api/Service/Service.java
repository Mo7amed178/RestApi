package com.reestApi.Rest.Api.Service;

import com.reestApi.Rest.Api.Model.Comments;
import com.reestApi.Rest.Api.Model.Posts;
import com.reestApi.Rest.Api.Model.Users;
import com.reestApi.Rest.Api.Repository.CommentsRepository;
import com.reestApi.Rest.Api.Repository.PostsRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final RestTemplate restTemplate;
    PostsRepository postsRepository;
    CommentsRepository commentsRepository;

    public Service(RestTemplate restTemplate, PostsRepository postsRepository, CommentsRepository commentsRepository) {
        this.restTemplate = restTemplate;
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
    }

    public List<Users> getAllUsers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Users>> responseEntity =
                restTemplate.exchange("https://gorest.co.in/public/v2/users", HttpMethod.GET,
                        entity, new ParameterizedTypeReference<List<Users>>() {});
        List<Users> users = responseEntity.getBody();
        return users;
    }


    public List<Posts> getAllPosts() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Posts>> responseEntity =
                restTemplate.exchange("https://gorest.co.in/public/v2/posts", HttpMethod.GET,
                        entity, new ParameterizedTypeReference<List<Posts>>() {});
        List<Posts> posts = responseEntity.getBody();
        return posts;
    }

    public List<Comments> getAllComments() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Comments>> responseEntity =
                restTemplate.exchange("https://gorest.co.in/public/v2/comments", HttpMethod.GET,
                        entity, new ParameterizedTypeReference<List<Comments>>() {});
        List<Comments> comments = responseEntity.getBody();
        return comments;
    }

    public Optional<Posts> getPostByUserId(String userId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Posts>> responseEntity =
                restTemplate.exchange("https://gorest.co.in/public/v2/posts", HttpMethod.GET,
                        entity, new ParameterizedTypeReference<List<Posts>>() {});
        List<Posts> posts = responseEntity.getBody();
        System.out.println(posts);

        return postsRepository.findByUserId(userId);
    }

    public Optional<Comments> getPostByPostId(String postId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Comments>> responseEntity =
                restTemplate.exchange("https://gorest.co.in/public/v2/posts", HttpMethod.GET,
                        entity, new ParameterizedTypeReference<List<Comments>>() {});
        List<Comments> comments = responseEntity.getBody();
        System.out.println(comments);

        return commentsRepository.findByPostId(postId);
    }

}
