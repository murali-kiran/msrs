package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrs.model.Incident;

@Repository 
public interface IncidentRepo extends PagingAndSortingRepository<Incident, Integer>{
	
}
