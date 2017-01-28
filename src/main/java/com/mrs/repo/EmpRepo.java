package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mrs.model.Emp;

@RepositoryRestResource
public interface EmpRepo extends PagingAndSortingRepository<Emp, Integer>{
 
}
