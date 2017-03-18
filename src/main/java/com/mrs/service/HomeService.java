package com.mrs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mrs.model.BenefitType;
import com.mrs.model.Emp;
import com.mrs.model.Incident;
import com.mrs.model.Nominee;
import com.mrs.model.OfficeLocation;

public interface HomeService {
	
	public Page<Emp> getAllEmployees(Pageable pageablep);
	public Emp getEmpById(Integer empid);
	public Emp createEmp(Emp emp);
	public Page<Emp> getAllEmployeesByEmp(Emp em,Pageable pageablep);
	
	public Nominee createNominee(Nominee nominee);
	public Incident createIncident(Incident incident);
	
	public List<BenefitType> getAllBenefitType();
	public BenefitType getBenefitTypeById(Integer id);
	
	public List<OfficeLocation> getAllOfficeLocation();
	public OfficeLocation getOfficeLocationById(Integer id);

}
