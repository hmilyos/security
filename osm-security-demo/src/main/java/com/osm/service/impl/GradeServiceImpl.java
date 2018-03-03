/**
 * 
 */
package com.osm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osm.dao.GradeDao;
import com.osm.dto.Grade;
import com.osm.service.GradeService;

/**
 * @author ouShiming
 *
 */
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public Grade findById(Integer id) {
		// TODO Auto-generated method stub
		return gradeDao.findById(id);
	}

}
