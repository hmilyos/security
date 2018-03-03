/**
 * 
 */
package com.osm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osm.dao.StudentDao;
import com.osm.dto.Student;
import com.osm.service.StudentService;

/**
 * @author ouShiming
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	

	@Autowired
	private StudentDao studentDao;

	@Override
	public int create(Student student) {
		return studentDao.create(student);
	}

	@Override
	public int update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public int delete(Integer id) {
		return studentDao.delete(id);
	}

	@Override
	public Student getById(Integer id) {
		return studentDao.getById(id);
	}

	@Override
	public List<Student> query() {
		return studentDao.query();
	}

	@Override
	public Student findStudentWithAddress(Integer id) {
		return studentDao.findStudentWithAddress(id);
	}

	@Override
	public List<Student> findByGradeId(Integer gradeId) {
		return studentDao.findByGradeId(gradeId);
	}

	@Override
	public List<Student> searchStudents(Map<String, Object> map) {
		return studentDao.searchStudents(map);
	}

	@Override
	public List<Student> searchStudents2(Map<String, Object> map) {
		return studentDao.searchStudents2(map);
	}

	@Override
	public List<Student> searchStudents3(Map<String, Object> map) {
		return studentDao.searchStudents3(map);
	}

	@Override
	public List<Student> searchStudents4(Map<String, Object> map) {
		return studentDao.searchStudents4(map);
	}

	@Override
	public List<Student> searchStudents5(Map<String, Object> map) {
		return studentDao.searchStudents5(map);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public int insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentDao.getStudentById(id);
	}
	
	@Override
	public List<Student> searchStudents6(String name,int age){
		return studentDao.searchStudents6(name, age);
	}
}
