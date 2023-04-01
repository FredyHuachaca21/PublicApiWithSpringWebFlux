package com.fredgar.pe.api.jsonplaceholder.service;

import com.fredgar.pe.api.jsonplaceholder.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {

  private final WebClient webClient;

  public PostServiceImpl(){
    this.webClient = WebClient.builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .build();
  }

  public Flux<Post> getPosts(){
    return webClient.get()
        .uri("/posts")
        .retrieve()
        .bodyToFlux(Post.class);
  }

  public Mono<Post> getPostById(int id){
    return webClient.get()
        .uri("/posts/{id}", id)
        .retrieve()
        .bodyToMono(Post.class);
  }

  public Flux<Post> getPostsByUserId(int userId){
    return webClient.get()
        .uri("/posts?userId={userId}", userId)
        .retrieve()
        .bodyToFlux(Post.class);
  }

  public Mono<Post> createPost(Post post){
    return webClient.post()
        .uri("/posts")
        .bodyValue(post)
        .retrieve()
        .bodyToMono(Post.class);
  }

  public Mono<Post> updatePost(int id, Post post){
    return webClient.put()
        .uri("/posts/{id}", id)
        .bodyValue(post)
        .retrieve()
        .bodyToMono(Post.class);
  }

  public Mono<Void> deletePost(int id){
    return webClient.delete()
        .uri("/posts/{id}", id)
        .retrieve()
        .bodyToMono(Void.class);
  }

}
