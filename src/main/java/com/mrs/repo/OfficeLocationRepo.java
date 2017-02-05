package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrs.model.OfficeLocation;

@Repository 
public interface OfficeLocationRepo extends PagingAndSortingRepository<OfficeLocation, Integer>{
	
}
