package com.mrs.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrs.model.Emp;
import com.mrs.repo.EmpRepo;
import com.mrs.service.HomeService;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	@Autowired
	HomeService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
    String all(Model model) {
        model.addAttribute("emps", service.getAllEmployees());
        return "index";
    }
	@GetMapping(value = "/searchEmp")
    String showSearch(Model model) {
		model.addAttribute("emp", new Emp());
		model.addAttribute("emps", new ArrayList<>());
        return "searchEmp";
    }
	@PostMapping( value = "/searchEmp")
    String getSearch(@ModelAttribute Emp emp, BindingResult bindingresult, Model model) {
		System.out.println("ggg"+bindingresult);
		model.addAttribute("emps", service.getAllEmployeesByEmp(emp));
		//model.addAttribute("emp", new Emp());
		//model.addAttribute("emps", new ArrayList<>());
        return "searchEmp";
    }
	
	@RequestMapping(value="/viewEmp",method = RequestMethod.GET)
    public String getEmp(@RequestParam(value="empid",required=true) Integer empid, Model model) {
		model.addAttribute("emp", service.getEmpById(empid));
		return "viewEmp";
    }
}
