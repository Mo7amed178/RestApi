package com.reestApi.Rest.Api.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class FindPostByUserId {
    private String userId;
}
