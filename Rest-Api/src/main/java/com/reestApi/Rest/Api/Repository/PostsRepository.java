package com.reestApi.Rest.Api.Repository;

import com.reestApi.Rest.Api.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository  extends JpaRepository<Posts, Long> {
    Optional<Posts> findByUserId(String userId);
}
