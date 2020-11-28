package com.cg.blogging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.CommentJPARepository;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentJPARepository commentJPARepository;

	@Override
	public List<Comment> addComment(Comment comment) {
		if(comment ==null)
		{
			return null;
		}
		else {
			
		commentJPARepository.saveAndFlush(comment);
		System.out.println(commentJPARepository.findAll());
		return commentJPARepository.findAll();
		
		}
	}

	@Override
	public List<Comment> deleteCommentById(int id) throws IdNotFoundException {
		if(commentJPARepository.findById(id)==null)
		{

			throw new IdNotFoundException("Comment not found for deleting");
		}
		
		commentJPARepository.deleteById(id);
		return commentJPARepository.findAll();
	}

	@Override
	public List<Comment> findAllComments() throws Exception {
		List<Comment> comment=commentJPARepository.findAll();
		if(comment.isEmpty())
		{
			throw new Exception("Comments are empty");
		}
		return comment;
	}

	@Override
	public List<Comment> findCommentsByPost(int id) {
		return commentJPARepository.searchCommentsByPost(id);
	}


	

}
