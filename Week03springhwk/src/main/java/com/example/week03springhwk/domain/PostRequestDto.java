package com.example.week03springhwk.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostRequestDto {
    private String nickname;
    private String title;
    private String contents;
    private String password;
}
