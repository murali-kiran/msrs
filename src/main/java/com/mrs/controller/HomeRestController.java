package com.mrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.model.Emp;
import com.mrs.repo.EmpRepo;

@RestController
@RequestMapping(value="/rest")
public class HomeRestController {

	@Autowired
	EmpRepo empRepo;
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Emp> all() {
		
        return (List<Emp>) this.empRepo.findAll();
    }
	@RequestMapping(value="/findOne",method = RequestMethod.GET)
    public Emp findOne() {
        return  this.empRepo.findOne(1);
    }
}
