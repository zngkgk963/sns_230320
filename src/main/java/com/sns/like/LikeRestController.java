package com.sns.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sns.like.bo.LikeBO;

@RestController
public class LikeRestController {

	@Autowired
	private LikeBO likeBO;
	
	// GET:    /like?postId=13        @RequestParam("postId")
	// GET:    /like/13				  @PathVariable
	@RequestMapping("/like/{postId}")
	public Map<String, Object> like(
			@PathVariable int postId, 
			HttpSession session) {
		
		// 로그인 여부 체크
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 300);
			result.put("errorMessage", "로그인을 해주세요.");
			return result;
		}
		
		// BO 호출 -> like 여부 체크
		likeBO.likeToggle(postId, userId);
		
		// 응답
		result.put("code", 1);
		result.put("result", "성공");
		return result;
	}
}