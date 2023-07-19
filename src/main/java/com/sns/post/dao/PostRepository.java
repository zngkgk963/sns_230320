package com.sns.post.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sns.post.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	
	// findAllByOrderByIdDesc
	public List<PostEntity> findAllByOrderByIdDesc();
}
