package com.mrs.repo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrs.model.Emp;

@Repository 
public interface EmpRepo extends PagingAndSortingRepository<Emp, Integer>{

	List<Emp> findByAatharnumber(BigInteger aatharnumber);
	List<Emp> findByPancard(String pancard);
	List<Emp> findByDob(Date dob);
	List<Emp> findByEmail(String email);
	List<Emp> findByDoj(Date doj);
	List<Emp> findByFirstname(String firstname);
	List<Emp> findByLastname(String lastname);
	List<Emp> findByPhone(String phone);
	
	
}
