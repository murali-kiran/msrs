package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mrs.model.Emp;
import java.math.BigInteger;
import java.util.List;
import java.lang.String;
import java.util.Date;

@RepositoryRestResource
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
