package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blogging.dao.PostJPARepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;

@Service
public class PostServiceImpl implements PostService{
	static Logger log = Logger.getLogger(PostServiceImpl.class.getName());

	
	@Autowired
	private PostJPARepository  postJPARepository;

	@Override
	public List<Post> updatePost(Post post) throws IdNotFoundException {
		log.info("Service Layer - Entry - updatePost");
		
			if(postJPARepository.existsById(post.getPostId()))
			{
				postJPARepository.save(post);
				
				return postJPARepository.findAll();
			}
			log.info("Service Layer - Exit - updatePost");
				throw new IdNotFoundException("post can not be updated.no post found");
	
			
}

	
	 public List<Post> viewAllPosts() {
		 log.info("Service Layer - Entry - retrieveallPosts");
	        
	        List<Post> posts=new ArrayList<Post>();
	        posts=postJPARepository.findAll();
	        if(posts==null) {
	            return null;
	        }
	        else {
	        	 log.info("Service Layer - Exit - retrieveallposts");
	        return posts;
	        }
	    }
	 
		
	 @Override
	public List<Post> getPostBySearchString(String searchStr) throws IdNotFoundException {
		 log.info("Service Layer - Entry - retrievePostby searchstring");
		 log.info("Service Layer - Exit - retrievePostby searchstring");
		List<Post> matchingPostsList=new ArrayList<Post>();
		matchingPostsList=postJPARepository.getPostBySearchString(searchStr);
		if(matchingPostsList.isEmpty()) {
			throw new IdNotFoundException("no posts found with given search string " +searchStr );
		}
		else {
			
			return matchingPostsList;
		}
	}

	@Override
	public Post deletePost(int id) throws IdNotFoundException {
		log.info("Service Layer - Entry - deletePost");
		log.info("Service Layer - Exit - updatePost");
		
		
		
		Post deletedPost=postJPARepository.findById(id).orElse(new Post());
		if(deletedPost.getPostId()!=0) {
			postJPARepository.deleteById(id);
			return deletedPost;
		}
		else {
			    throw new IdNotFoundException("deletion failed,no post found with given id " +id);
			}
	}


	@Override
	public List<Post> addPost(Post post) throws IdNotFoundException {
		log.info("Service Layer - Entry - addPost");
		log.info("Service Layer - Exit - addPost");
		
		if(post==null)
		{
		  throw new IdNotFoundException("cannot add community because the object passed is null!");
		}
		else {
			postJPARepository.saveAndFlush(post);
			List<Post> addPostList=postJPARepository.findAll();
			
			return addPostList;		
		}
	}
}
	

	
		
	
	
		
		
	

	
