package com.qingao.mgj.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileControler {

	@PostMapping("/filecontrollerupload")
	public String  upload(@RequestParam(value="file1") MultipartFile[] file1 ) throws IOException {
		
		
		
		for (MultipartFile f : file1) {
			String old_fileName=f.getOriginalFilename();
			
			StringBuffer fileName=new StringBuffer(UUID.randomUUID().toString());
					
						 fileName.append(old_fileName.substring(old_fileName.lastIndexOf(".")));
							
//						    //创建放置在服务器本地的文件
						    File localFile = new File("d:"+File.separator+"sysfiles190806"+File.separator+"uploadfiles"+File.separator+fileName);
						    //把传上来的文件写到本地文件
						    f.transferTo(localFile);
		}
	    
	    
	    
	    return "/upload_success.html";
	}
	
	@PostMapping("/filecontrollerupload_single")
	public String  upload_single(@RequestParam(value="file1") MultipartFile file1 ) throws IOException {
		
		
		
		String old_fileName=file1.getOriginalFilename();
			
		StringBuffer fileName=new StringBuffer(UUID.randomUUID().toString());
				
					 fileName.append(old_fileName.substring(old_fileName.lastIndexOf(".")));
				
		System.out.println(fileName);
				
		
//	    //创建放置在服务器本地的文件
	    File localFile = new File("d:"+File.separator+"sysfiles190806"+File.separator+"uploadfiles"+File.separator+fileName);
	    
	    
	    //把传上来的文件写到本地文件
	    file1.transferTo(localFile);
	    
	    
	    
	    return "/upload_success.html";
	}
	
	
}
