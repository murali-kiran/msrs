package com.mrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.model.Emp;
import com.mrs.repo.EmpRepo;
import com.mrs.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	EmpRepo empRepo;
	
	@Override
	public List<Emp> getAllEmployees(Emp emp) {
		return (List<Emp>) empRepo.findAll();
	}

	@Override
	public Emp getEmpById(Integer empid) {
		return empRepo.findOne(empid);
	}

}
