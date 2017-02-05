package com.mrs.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mrs.model.BenefitType;

@Repository 
public interface BenefitTypeRepo extends PagingAndSortingRepository<BenefitType, Integer>{
	
}
