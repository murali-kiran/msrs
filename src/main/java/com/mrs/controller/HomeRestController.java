package com.mrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrs.model.Emp;
import com.mrs.service.HomeService;

@RestController
@RequestMapping(value="/rest")
public class HomeRestController {

	@Autowired
	HomeService homeService;
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Emp> all() {
        return homeService.getAllEmployees(new Emp());
    }
	@RequestMapping(value="/getEmp",method = RequestMethod.GET)
    public Emp getEmp(@RequestParam(value="empid",required=true) Integer empid) {
        return homeService.getEmpById(empid);
    }
}
