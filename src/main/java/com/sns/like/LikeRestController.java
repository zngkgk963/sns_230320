package com.sns.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeRestController {
	
	// GET:		/like?postId=13			@RequestParam("postId")
	// GET:		/like/13				@PathVariable
	@RequestMapping("/like/{postId}")
	public Map<String, Object> like(
			@PathVariable int postId,
			HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			result.put("code", 300);
			result.put("errorMessage", "로그인이 필요합니다.");
			return result;
		}
		
		
		// BO 호출 -> like 여부 체크
		likeBO.likeToggle(postId, userId);
		
		// 응답
	}
}
