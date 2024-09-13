package com.example.mywebservice.controller;

import com.example.mywebservice.dto.PostDto;
import com.example.mywebservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    @Autowired
    private PostService postService;

    //전체 게시글 목록 조회
    @GetMapping
    public List<PostDto> list() {
        return postService.getAllPosts();
    }

    //특정 게시글 상세 조회
    @GetMapping("/{id}")
    public Optional<PostDto> get(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    //새로운 게시글 생성
    @PostMapping
    public PostDto create(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    //게시글 수정
    @PutMapping("/{id}")
    public PostDto update(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
