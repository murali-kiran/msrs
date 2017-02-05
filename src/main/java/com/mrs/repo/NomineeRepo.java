package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrs.model.Nominee;

@Repository 
public interface NomineeRepo extends PagingAndSortingRepository<Nominee, Integer>{
		
}
