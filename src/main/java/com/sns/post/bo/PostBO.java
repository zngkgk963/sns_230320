package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.post.dao.PostMapper;
import com.sns.post.dao.PostRepository;
import com.sns.post.entity.PostEntity;

@Service
public class PostBO {

	@Autowired
	private PostMapper postMapper;  // mybatis 지금 안씀
	
	@Autowired
	private PostRepository postRespository; // JPA 
	
	public List<PostEntity> getPostList() {
		return postRespository.findAllByOrderByIdDesc();
	}
}