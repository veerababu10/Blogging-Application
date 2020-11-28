package com.cg.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;


public interface CommentService {
	
	public List<Comment> addComment(Comment comment);
	public List<Comment> deleteCommentById(int id) throws IdNotFoundException;
	public List<Comment> findAllComments() throws Exception;
	public List<Comment> findCommentsByPost(int id);
	
}
