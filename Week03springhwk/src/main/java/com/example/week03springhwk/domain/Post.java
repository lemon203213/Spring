package com.example.week03springhwk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nickname;//닉네임

    @Column(nullable = false)
    private String title;//게시물 제목
    @Column(nullable = false)
    private String contents;//게시물 내용

    @Column(nullable = false)
    @JsonIgnore
    private String password;//게시물 비밀번호

    public Post(String nickname,String title, String contents, String passwoed, String time) {
        this.nickname = nickname;
        this.title=title;
        this.contents = contents;
        this.password=passwoed;

    }
    public Post(PostRequestDto requestDto) {
        this.nickname = requestDto.getNickname();
        this.title=requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password=requestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto){
        this.nickname=postRequestDto.getNickname();
        this.title=postRequestDto.getTitle();
        this.contents=postRequestDto.getContents();
        this.password= postRequestDto.getPassword();

    }
}