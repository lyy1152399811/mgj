package com.qingao.mgj.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/filecontroller")
public class FileController {
	@PostMapping("file")
	@RequestScope
	public String fileUpload(@RequestParam("file1") MultipartFile[] file1) {
		String filename=null;
		for (MultipartFile multipartFile : file1) {
			String oldname =multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			filename= UUID.randomUUID().toString()+oldname;
			String path = "c:/aaa/file";
			File dest = new File(path,filename);
			if (!dest.getParentFile().exists()) {
				// 父目录不存在就创建一个
				dest.getParentFile().mkdir();
			}			// 保存文件
				try {
					multipartFile.transferTo(dest);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		System.out.println(filename);
		return filename;

	}
}
