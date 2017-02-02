package com.mrs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.model.Emp;
import com.mrs.repo.EmpRepo;
import com.mrs.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmpRepo empRepo;
	
	@Override
	public List<Emp> getAllEmployees(Emp emp) {
		logger.info("find Employees by "+emp);
		return (List<Emp>) empRepo.findAll();
	}

	@Override
	public Emp getEmpById(Integer empid) {
		logger.info("find Employees by empid : "+empid);
		return empRepo.findOne(empid);
	}

}
