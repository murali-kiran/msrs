package com.mrs.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrs.model.Emp;
import com.mrs.service.HomeService;


@Controller
@RequestMapping(value="/home")
public class HomeController {
	@Autowired
	HomeService homeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
    String all(Model model) {
        //model.addAttribute("emps", homeService.getAllEmployees());
        return "index";
    }
	@GetMapping(value = "/searchEmp")
    String showSearch(Model model) {
		model.addAttribute("emp", new Emp());
		model.addAttribute("emps", new ArrayList<>());
        return "searchEmp";
    }
	@PostMapping( value = "/searchEmp")
    String getSearch(@ModelAttribute Emp emp, BindingResult bindingresult, Model model, @SortDefault("firstname") Pageable pageable) {
		//model.addAttribute("page", homeService.getAllEmployeesByEmp(emp,pageable));
		
		Page<Emp> empPage = homeService.getAllEmployees(pageable);
        PageWrapper<Emp> page = new PageWrapper<Emp>(empPage, "/home/searchEmp");
        model.addAttribute("emps", page.getContent());
        model.addAttribute("page", page);
        return "searchEmp";
    }
	@RequestMapping(value="/viewEmp",method = RequestMethod.GET)
    public String getEmp(@RequestParam(value="empid",required=true) Integer empid, Model model) {
		model.addAttribute("emp", homeService.getEmpById(empid));
		return "viewEmp";
    }
	@GetMapping( value = "/empList")
    String getEmpList(@ModelAttribute Emp emp, BindingResult bindingresult, Model model, Pageable pageable) {
	/*	model.addAttribute("emps", homeService.getAllEmployees());
		model.addAttribute("emp", null);*/
		model.addAttribute("emp", null);
		Page<Emp> empPage = homeService.getAllEmployees(pageable);
        PageWrapper<Emp> page = new PageWrapper<Emp>(empPage, "/home/empList");
        model.addAttribute("emps", page.getContent());
        model.addAttribute("page", page);
        return "searchEmp";
    }
	@GetMapping(value = "/createEmp")
    String createEmpForm(@RequestParam(value = "empid", required = false) Integer empid,Model model) {
		Emp emp = null;
		if(empid!=null)
			emp=homeService.getEmpById(empid);
        model.addAttribute("emp",  emp == null ? new Emp() : emp);
        return "createEmp";
    }
	@PostMapping(value = "/createEmp")
    String createEmpSubmit(@ModelAttribute Emp emp,BindingResult bindingResult) {
		homeService.createEmp(emp);
		return "redirect:/home/searchEmp";
    }
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	    binder.registerCustomEditor(Date.class, editor);
	}
}
