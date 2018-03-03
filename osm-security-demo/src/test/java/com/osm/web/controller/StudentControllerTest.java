/**
 * 
 */
package com.osm.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author ouShiming
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenSearchStudents6Success() throws Exception {
		mockMvc.perform(get("/student/searchStudents6")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenGetStudentById() throws Exception {
		mockMvc.perform(get("/student/getStudentById/10")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenInsertStudentSuccess() throws Exception {
		mockMvc.perform(post("/student/insertStudent")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenUpdateStudentSuccess() throws Exception {
		mockMvc.perform(put("/student/updateStudent/7")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenSearchStudentsSuccess5() throws Exception {
		mockMvc.perform(get("/student/searchStudents5")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenSearchStudentsSuccess4() throws Exception {
		mockMvc.perform(get("/student/searchStudents4")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenSearchStudentsSuccess3() throws Exception {
		mockMvc.perform(get("/student/searchStudents3")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenSearchStudentsSuccess2() throws Exception {
		mockMvc.perform(get("/student/searchStudents2")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenSearchStudentsSuccess() throws Exception {
		mockMvc.perform(get("/student/searchStudents")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void whenCreateSuccess() throws Exception {
		
		String content = "{\"name\":\"张三\",\"age\":\"11\"}";
		String reuslt = mockMvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(reuslt);
	}
	
	@Test
	public void whenUpdateSuccess() throws Exception {
	
		String content = "{\"id\":\"7\", \"name\":\"明\",\"age\":\"23\"}";
		String reuslt = mockMvc.perform(put("/student/7").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(reuslt);
	}
	
	@Test
	public void whenDeleteSuccess() throws Exception {
		String reuslt = mockMvc.perform(delete("/student/8")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(reuslt);
	}
	
	@Test
	public void whenGetInfoSuccess() throws Exception {
		String result = mockMvc.perform(get("/student/7")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("明"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	@Test
	public void whenFindByGradeIdSuccess() throws Exception {
		String result = mockMvc.perform(get("/student/findByGradeId/2")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.gradeName").value("大二"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	@Test
	public void whenGetInfoWithAddressSuccess() throws Exception {
		String result = mockMvc.perform(get("/student/withAddress/9")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("bei"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	@Test
	public void whenQuerySuccess() throws Exception {
		String result = mockMvc.perform(
				get("/student")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(2))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
}
