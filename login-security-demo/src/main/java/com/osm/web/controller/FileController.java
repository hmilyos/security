/**
 * 
 */
package com.osm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.osm.domain.FileInfo;

/**
 * @author ouShiMing
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {
	String folder = "G:/workspace-sts-3.7.3.RELEASE/login-security-demo/src/main/java/com/osm/web";

	
	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException{
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		File localFile = new File(folder, new Date().getTime() + ".txt");
		
		file.transferTo(localFile);	//保存到本地
		//file.getInputStream();		//保存到云端
		
		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		try(FileInputStream inputStream =	new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();
				) {
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
