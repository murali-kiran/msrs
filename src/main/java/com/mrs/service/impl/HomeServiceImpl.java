package com.mrs.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mrs.model.BenefitType;
import com.mrs.model.Emp;
import com.mrs.model.Incident;
import com.mrs.model.Nominee;
import com.mrs.model.OfficeLocation;
import com.mrs.repo.BenefitTypeRepo;
import com.mrs.repo.EmpRepo;
import com.mrs.repo.IncidentRepo;
import com.mrs.repo.NomineeRepo;
import com.mrs.repo.OfficeLocationRepo;
import com.mrs.service.HomeService;

//import scala.annotation.meta.setter;

@Service
public class HomeServiceImpl implements HomeService{

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	EmpRepo empRepo;
	
	@Autowired
	BenefitTypeRepo benefitTypeRepo;
	
	@Autowired
	IncidentRepo incidentRepo;
	
	@Autowired
	NomineeRepo nomineeRepo;
	
	@Autowired
	OfficeLocationRepo officeLocationRepo;
	
	@Override
	public Page<Emp> getAllEmployees(Pageable pageable) {
		return empRepo.findAll(pageable);
	}

	@Override
	public Page<Emp> getAllEmployeesByEmp(Emp emp,Pageable pageable) {
		logger.info("find Employees by "+emp);
		return empRepo.findAll(pageable);
	}
	@Override
	public Emp getEmpById(Integer empid) {
		logger.info("find Employees by empid : "+empid);
		return empRepo.findOne(empid);
	}

	@Override
	public Emp createEmp(Emp emp) {
		logger.info("Saving Employee "+emp);
		if(emp.getEmpid()==0){
			emp.setCreatedtime(new Date());
		}
		emp.setModifiedtime(new Date());
		return empRepo.save(emp);
	}
	
	@Override
	public Nominee createNominee(Nominee nominee) {
		logger.info("Saving Nominee "+nominee);
		return nomineeRepo.save(nominee);
	}

	@Override
	public Incident createIncident(Incident incident) {
		logger.info("Saving Incident "+incident);
		return incidentRepo.save(incident);
	}

	@Override
	public List<BenefitType> getAllBenefitType() {
		return (List<BenefitType>)benefitTypeRepo.findAll();
	}

	@Override
	public BenefitType getBenefitTypeById(Integer id) {
		return benefitTypeRepo.findOne(id);
	}

	@Override
	public List<OfficeLocation> getAllOfficeLocation() {
		return (List<OfficeLocation>)officeLocationRepo.findAll();
	}

	@Override
	public OfficeLocation getOfficeLocationById(Integer id) {
		return officeLocationRepo.findOne(id);
	}
	
}
