package com.judge.auth.dto;

import lombok.*;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class JWTEncodable {
    private String email;
    private String userName;
}
