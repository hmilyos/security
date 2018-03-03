/**
 * 
 */
package com.osm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osm.dto.FileInfo;



/**
 * @author ouShiming
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {

	private String folder = "G:\\stsWorkspace\\osm-security-demo\\src\\main\\java\\com\\osm\\web\\controller";

	@PostMapping	//入参的file一定要和前端传过来的名字一致
	public FileInfo upload(MultipartFile file) throws Exception {

		System.out.println(file.getName());	//上传过来的别名
		System.out.println(file.getOriginalFilename());	//原始文件名
		System.out.println(file.getSize());	//文件大小

		File localFile = new File(folder, new Date().getTime() + ".txt");
		
		//InputStream inputStream = file.getInputStream();	//拿到这个文件流然后可以上传到文件服务器
		
		file.transferTo(localFile);

		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

		//这是jdk7的语法，以前的还要自己关闭流
		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();) {
			
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		} 

	}

}
