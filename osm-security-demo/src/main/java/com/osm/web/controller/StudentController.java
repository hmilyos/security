/**
 * 
 */
package com.osm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osm.dto.Grade;
import com.osm.dto.Student;
import com.osm.service.GradeService;
import com.osm.service.StudentService;

/**
 * @author ouShiming
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GradeService gradeservice;
	
	@GetMapping("/searchStudents6")
	public void searchStudents6() {
		List<Student> studentList = studentService.searchStudents6("%4%", 14);
		for(Student student:studentList){
			System.out.println(student);
		}
	}
	
	@GetMapping("/getStudentById/{id:\\d+}")
	public void getStudentById(@PathVariable int id){
		System.out.println("id-->" + id);
		Student student = studentService.getStudentById(id);
		System.out.println(student);
		byte []pic=student.getPic();
		try{
			File file = new File("d://boy2.jpg");
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(pic);
			outputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@PostMapping("/insertStudent")
	public void insertStudent(){
		Student student=new Student();
		student.setName("张三4");
		student.setAge(14);
		student.setRemark("很长的本文...");
		byte []pic=null;
		try{
			File file=new File("c://timg.jpg");
			InputStream inputStream=new FileInputStream(file);
			pic=new byte[inputStream.available()];
			inputStream.read(pic);
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		student.setPic(pic);
		int row = studentService.insertStudent(student);
		System.out.println("row-->" + row);
	}
	
	@PutMapping("/updateStudent/{id:\\d+}")
	public void updateStudent(@PathVariable int id) {
		System.out.println("id-->" + id);
		Student student = new Student();
		student.setId(8);
		student.setName("Hello");
		int row = studentService.updateStudent(student);
		System.out.println("row-->" + row);
	}
	
	
	@GetMapping("/searchStudents5")
	public void searchStudents5() {
		Map<String,Object> map = new HashMap<>();
		List<Integer> gradeIds=new ArrayList<Integer>();
		gradeIds.add(1);
		gradeIds.add(2);
		map.put("gradeIds", gradeIds);
		List<Student> searchStudents = studentService.searchStudents5(map);
		System.out.println("size-->" + searchStudents.size());
		for (Student student : searchStudents) {
			System.out.println(ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE));
		}
	}
	
	@GetMapping("/searchStudents4")
	public void searchStudents4() {
		Map<String,Object> map = new HashMap<>();
		//map.put("gradeId", 2);
		//map.put("name", "%h%");
		map.put("age", 23);
		List<Student> searchStudents = studentService.searchStudents4(map);
		System.out.println("size-->" + searchStudents.size());
		for (Student student : searchStudents) {
			System.out.println(ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE));
		}
	}
	
	@GetMapping("/searchStudents3")
	public void searchStudents3() {
		Map<String,Object> map = new HashMap<>();
		map.put("gradeId", 2);
		map.put("name", "%h%");
		map.put("age", 23);
		List<Student> searchStudents = studentService.searchStudents3(map);
		System.out.println("size-->" + searchStudents.size());
		for (Student student : searchStudents) {
			System.out.println(ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE));
		}
	}
	
	@GetMapping("/searchStudents2")
	public void searchStudents2() {
		Map<String,Object> map = new HashMap<>();
		//map.put("searchBy", "gradeId");
		map.put("searchBy", "name");
		map.put("gradeId", 2);
		map.put("name", "%h%");
		map.put("age", 11);
		List<Student> searchStudents = studentService.searchStudents2(map);
		System.out.println("size-->" + searchStudents.size());
		for (Student student : searchStudents) {
			System.out.println(ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE));
		}
	}

	@GetMapping("/searchStudents")
	public void searchStudents() {
		Map<String,Object> map = new HashMap<>();
		map.put("gradeId", 2);
		map.put("name", "%h%");
		// map.put("age", 11);
		List<Student> searchStudents = studentService.searchStudents(map);
		for (Student student : searchStudents) {
			System.out.println(ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE));
		}
	}
	
	@PostMapping
	public Student create(@RequestBody Student stu) {
		System.out.println(ReflectionToStringBuilder.toString(stu, ToStringStyle.MULTI_LINE_STYLE));
		stu.setId(studentService.create(stu));
		return stu;
	}
	
	@PutMapping("/{id:\\d+}")
	public Student update(@RequestBody Student stu) {
		System.out.println(ReflectionToStringBuilder.toString(stu, ToStringStyle.MULTI_LINE_STYLE));
		stu.setId(studentService.update(stu));
		return stu;
	}
	
	@GetMapping("/findByGradeId/{id:\\d+}")
	public Grade findByGradeId(@PathVariable int id) {
		System.out.println(id);
		return gradeservice.findById(id);
	}
	
	@GetMapping("/{id:\\d+}")
	public Student getById(@PathVariable int id) {
		System.out.println(id);
		Student student = studentService.findStudentWithAddress(id);
		System.out.println("----");
		System.out.println(student);
		System.out.println("----");
		return student;
	}
	
	
	@GetMapping("/withAddress/{id:\\d+}")
	public Student findStudentWithAddress(@PathVariable int id) {
		System.out.println(id);
		return studentService.findStudentWithAddress(id);
	}
	
	@GetMapping()
	public List<Student> query(){
		List<Student> query = studentService.query();
		return query;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public Student delete(@PathVariable Integer id) {
		Student stu = new Student();
		System.out.println("id--->" + id);
		stu.setId(studentService.delete(id));
		return stu;
	}
}
