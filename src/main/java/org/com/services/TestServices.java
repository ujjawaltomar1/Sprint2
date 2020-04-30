package org.com.services;

import java.util.List;
import java.util.Optional;

import org.com.dao.TestRepository;
import org.com.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestServices {
	
	@Autowired
	private TestRepository testRepository; 
	

	
	
	public Optional<Test> findTestById(Integer id) {
		return testRepository.findById(id);		
	}
	

	public List<Test> findAllTests() {
		return testRepository.findAll();		
	}
	
	public void saveTest(Test t) {
		testRepository.save(t);
		
	}

	public void deleteTest(Integer id) {
		testRepository.deleteById(id);
		
	}



}

