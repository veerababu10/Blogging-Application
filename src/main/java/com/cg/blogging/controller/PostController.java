package com.cg.blogging.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.BloggingAppApplication;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

import com.cg.blogging.exception.IdNotFoundException;

import com.cg.blogging.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;
    private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
    
    
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> viewAllPosts() {
    	log.info("Controller Layer - Entry - retrieveALLPosts");
		log.info("Controller Layer - Exit - retrieveAllPosts");
		
    	
        List<Post> posts = postService.viewAllPosts();
        if (posts.isEmpty()) {
            return new ResponseEntity("Sorry! Bloggers not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);

 

    }
    
    
    
    
    
    

    @PostMapping("/posts")
    public ResponseEntity<List<Post>> insertPost(  @RequestBody Post post) throws IdNotFoundException {
    	log.info("Controller Layer - Entry - Post");
    	log.info("Controller Layer - Exit - addPost");
        List<Post> addedPost = null;
        addedPost=postService.addPost(post);
        return new ResponseEntity<List<Post>>(addedPost, HttpStatus.OK);
    }
	
    
    

    @PutMapping("/posts")
	public ResponseEntity<List<Post>> updatePost(@RequestBody Post post) throws IdNotFoundException{
    	log.info("Controller Layer - Entry - updatePost");
		log.info("Controller Layer - Exit - updatePost");
    	
		List<Post> posts=null;
		posts= postService.updatePost(post);
		
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable int id) throws IdNotFoundException {
    	log.info("Controller Layer - Entry - deletePost");
		log.info("Controller Layer - Exit - deletePost");
    	
        Post deletedPost = postService.deletePost(id);
        return new ResponseEntity<Post>(deletedPost, HttpStatus.OK);
    }

  
   
    

   
   
    @GetMapping("/posts/{searchStr}")
    public ResponseEntity<List<Post>> getPostBySearchString(@PathVariable  String searchStr) throws IdNotFoundException{
    	log.info("Controller Layer - Entry - retrieveALLPosts");
		log.info("Controller Layer - Exit - retrieveAllPosts");
    	
        List<Post> matchingPostsList = postService.getPostBySearchString(searchStr);
       
        return new ResponseEntity<List<Post>>(matchingPostsList, HttpStatus.OK);
   }
   

   
}