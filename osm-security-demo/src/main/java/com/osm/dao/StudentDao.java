/**
 * 
 */
package com.osm.dao;


import java.util.List;
import java.util.Map;

import com.osm.dto.Student;

/**
 * @author ouShiming
 *
 */
public interface StudentDao {
	int create(Student student);
	
	int update(Student student);
	
	int delete(Integer id);
	
	Student getById(Integer id);
	
	Student findStudentWithAddress(Integer id);
	
	List<Student> query();
	
	List<Student> findByGradeId(Integer gradeId);
	
	List<Student> searchStudents(Map<String, Object> map);
	
	List<Student> searchStudents2(Map<String, Object> map);
	
	List<Student> searchStudents3(Map<String, Object> map);
	
	List<Student> searchStudents4(Map<String, Object> map);
	
	List<Student> searchStudents5(Map<String, Object> map);
	
	int updateStudent(Student student);
	
	int insertStudent(Student student);
	
	Student getStudentById(Integer id);
	
	List<Student> searchStudents6(String name, int age);
}
