package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

import com.cg.blogging.exception.IdNotFoundException;

public interface PostService {
	
    public List<Post> addPost(Post post) throws IdNotFoundException;
	public List <Post> updatePost(Post post) throws IdNotFoundException;
	public Post deletePost(int id) throws IdNotFoundException;
	public List<Post> viewAllPosts() ;
    public List<Post> getPostBySearchString(String searchStr) throws IdNotFoundException;
    
	
	
	 
	

}

