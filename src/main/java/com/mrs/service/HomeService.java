package com.mrs.service;

import java.util.List;
import com.mrs.model.Emp;

public interface HomeService {
	
	public List<Emp> getAllEmployees(Emp emp);
	public Emp getEmpById(Integer empid);

}
