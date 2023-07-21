package com.sns.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.dao.CommentMapper;

@Service
public class CommentBO {
	
	@Autowired CommentMapper commentMapper;
	
//	postId
//	userId
//	content
	public int addComment(int postId, int userId, 
			String content) {
		
		
		return commentMapper.insertComment(postId, userId, content);
	}
	
}
