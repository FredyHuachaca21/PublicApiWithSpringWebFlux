package com.fredgar.pe.controller;

import com.fredgar.pe.api.jsonplaceholder.model.Post;
import com.fredgar.pe.api.jsonplaceholder.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostServiceImpl postService;

  @GetMapping
  public ResponseEntity<?> getPosts(){
    return ResponseEntity.ok(postService.getPosts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPostById(@PathVariable int id){
    return ResponseEntity.ok(postService.getPostById(id));
  }

  @PostMapping
  public ResponseEntity<?> createPost(@RequestBody Post post){
    return ResponseEntity.ok(postService.createPost(post));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updatePost(@PathVariable int id, @RequestBody Post post){
    return ResponseEntity.ok(postService.updatePost(id, post));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletePost(@PathVariable int id){
    return ResponseEntity.ok(postService.deletePost(id));
  }

}
