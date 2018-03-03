package com.osm.services.impl;

import org.springframework.stereotype.Service;

import com.osm.services.TestValidatorService;

@Service
public class TestValidatorServiceImpl implements TestValidatorService {

	@Override
	public String greeting(String name) {
		System.out.println("Service-->" + name);
		return "Hello " + name;
	}

}
