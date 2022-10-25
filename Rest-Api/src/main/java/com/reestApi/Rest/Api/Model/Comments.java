package com.reestApi.Rest.Api.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    @Column(name = "Id")
    private String id;
    @JsonProperty("post_id")
    @Column(name = "post_id")
    private String postId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "body")
    private String body;
}
