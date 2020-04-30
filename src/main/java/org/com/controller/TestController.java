package org.com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.com.model.Test;
import org.com.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exam")
//@CrossOrigin("http://localhost:4200")
public class TestController {
	
	@Autowired
	private TestServices testService;
	
	
	@RequestMapping("/allTests")
	public List<Test>getAllTests(){
		
		return testService.findAllTests();
		
	}
	
	@PostMapping("/addTest")
	public String saveTest( @Valid @RequestBody Test T , BindingResult result) {
		Optional<Test>findById=testService.findTestById(T.getTestId());
		
		if (result.hasErrors())
		{
			return "Invalid input/inputs";
		}
		else {
		if(!findById.isPresent()) {
			testService.saveTest(T);
			return "Successfully Added";
		}
		else
			return "Already Present";
		}
			
		
	}
	
	
	@DeleteMapping("/deleteTest/{id}")
	public String removeProduct(@PathVariable("id") int id) {
		Optional<Test>findById=testService.findTestById(id);
		if(findById.isPresent()) {
			testService.deleteTest(id);
			return "test removed";
		}
		else
			return "test not present";
	}

	@PutMapping("/updateTest")
	public String updateProduct(@Valid @RequestBody Test T , BindingResult result ) {
		
		if (result.hasErrors())
			return "Invalid Input/Inputs";
		else {
			Optional<Test>findById=testService.findTestById(T.getTestId());
		
		if(findById.isPresent()) {
			testService.saveTest(T);
			return "test  updated";
		}
		else
			return "test not present";
	
	
}
	
}
}
