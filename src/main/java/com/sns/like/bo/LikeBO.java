package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.dao.LikeMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;
	
	//input: 누가, 어느글에
	//output: X
	public void likeToggle(int postId, int userId) {
		// 셀렉트 => count(*)
		if (likeMapper.selectLikeCountByPostIdUserId(postId, userId) > 0) {
			// 삭제
			
		} else {
			// 추가
			likeMapper.insertLike(postId, userId);
		}
	}
	
}
