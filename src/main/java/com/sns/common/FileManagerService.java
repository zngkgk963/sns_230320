package com.sns.common;

import org.springframework.stereotype.Component;

@Component
public class FileManagerService {
	
	public static final String FILE_UPLOAD_PATH = "D:\\parkjaehyun\\6_spring_project\\sns\\workspace\\images/";
	
	public String saveFile(String loginId, MultipartFile file) {
		
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
	}
}
