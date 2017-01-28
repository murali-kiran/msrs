package com.mrs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrs.repo.EmpRepo;

@Controller
@RequestMapping(value="/home")
public class HomeController {

	@Autowired
	EmpRepo empRepo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
    String all(Model model) {
        //model.addAttribute("emps", this.empRepo.findAll());
        return "index";
    }
}
