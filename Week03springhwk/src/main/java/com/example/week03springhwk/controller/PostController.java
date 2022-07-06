package com.example.week03springhwk.controller;

import com.example.week03springhwk.domain.Post;
import com.example.week03springhwk.domain.PostRepository;
import com.example.week03springhwk.domain.PostRequestDto;
import com.example.week03springhwk.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;
    private Long id;

    @PostMapping("/api/posts")//게시물 작성
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post= new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")//전체 게시물 조회
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/posts/{id}")//id 게시물 조회
    public Optional<Post> readPost(@PathVariable Long id){
        return postRepository.findById(id);
    }

    //비밀번호랑 비교해서 맞으면 삭제 & 수정이 가능하도록 해야함
   @DeleteMapping("/api/posts/{id}")//게시물 삭제
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto ){
       Optional<Post> post=postRepository.findById(id);
       if(post.isPresent()){
           if(post.get().getPassword().equals(requestDto.getPassword())){
               postRepository.deleteById(id);
           }else {
               System.out.println("비밀번호가 일치하지 않습니다.");
           }
       }
       return id;
    }

    @PutMapping("/api/posts/{id}")//게시물 수정
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            if (post.get().getPassword().equals(requestDto.getPassword())) {
                postService.update(id, requestDto);
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
        return id;
    }

}
