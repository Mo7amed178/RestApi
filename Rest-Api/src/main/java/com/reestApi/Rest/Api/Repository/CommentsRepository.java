package com.reestApi.Rest.Api.Repository;

import com.reestApi.Rest.Api.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Optional<Comments>findByPostId(String postId);
}
