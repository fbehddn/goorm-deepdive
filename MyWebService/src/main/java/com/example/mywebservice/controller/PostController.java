package com.example.mywebservice.controller;

import com.example.mywebservice.dto.PostDto;
import com.example.mywebservice.entity.User;
import com.example.mywebservice.service.PostService;
import com.example.mywebservice.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserDetailService userService;

    // 게시글 전체 보기
    @GetMapping
    public String list(Model model, Authentication authentication) {
        List<PostDto> postDtos = postService.getAllPosts();
        model.addAttribute("posts", postDtos);

        // 로그인된 사용자 정보 추가
        String email = authentication.getName(); // 로그인된 사용자의 이메일 가져오기
        User user = (User) userService.loadUserByUsername(email); // 이메일로 사용자 정보 찾기
        model.addAttribute("nickname", user.getNickname()); // 사용자 닉네임 추가

        return "list";
    }

    // 게시글 작성하기: 작성폼
    @GetMapping("/create")
    public String createForm(Model model, Authentication authentication) {
        PostDto postDto = new PostDto();

        // 로그인한 사용자의 닉네임 가져오기
        String email = authentication.getName();
        User user = (User) userService.loadUserByUsername(email);
        postDto.setAuthor(user.getNickname()); // 작성자 이름 설정

        model.addAttribute("post", postDto); // 작성폼에 사용할 데이터 모델로 넘기기
        return "create";
    }

    // 게시글 작성하기: 게시글 등록
    @PostMapping("/create")
    public String createPost(@ModelAttribute("postDto") PostDto postDto) {
        postService.createPost(postDto);
        return "redirect:/posts";
    }

    // 게시글 상세 보기
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        model.addAttribute("post", postDto);
        return "detail";
    }

    // 게시글 업데이트: 업데이트폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        PostDto postDto = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        model.addAttribute("post", postDto);
        return "edit";
    }

    // 게시글 업데이트: 업데이트 정보 등록
    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute("post") PostDto updatePostDto) {
        postService.updatePost(id, updatePostDto);
        return "redirect:/posts";
    }

    // 게시글 삭제
    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
