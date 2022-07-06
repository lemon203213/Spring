package com.example.week03springhwk.service;

import com.example.week03springhwk.domain.Post;
import com.example.week03springhwk.domain.PostRepository;
import com.example.week03springhwk.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor//필요하면 만들어
@Service
public class PostService { // 업데이트
    private final PostRepository postRepository;

    @Transactional//db에 넣어줘
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다."));

        post.update(requestDto);
        return id;
    }


}