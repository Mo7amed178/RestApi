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
public class Posts {
    @Id
    @Column(name = "id")
    private String id;
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private String userId;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
}
