package com.kartik.joblisting.controllers;

import javax.servlet.http.HttpServletResponse;

import com.kartik.joblisting.repository.PostRepository;
import com.kartik.joblisting.model.Post;
import com.kartik.joblisting.repository.SearchRepository;
import com.kartik.joblisting.repository.SearchRepositoryImplemen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository sri;

    @ApiIgnore
    @RequestMapping(value = "/")
   public void redirect(HttpServletResponse response) throws IOException {
       response.sendRedirect("/swagger-ui.html");
   }

   @GetMapping("/allPosts")
   @CrossOrigin
   public List<Post> getAllPosts(){
        return repo.findAll();
   }

   @GetMapping("/posts/{text}")
   @CrossOrigin
   public List<Post> search(@PathVariable String text){
        return sri.findByText(text);
   }

   @PostMapping("/post")
   @CrossOrigin
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
   }
}
