package com.fitproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fitproject.domain.Lead;

@Repository
public interface LeadRepository extends CrudRepository<Lead, Long> {

}
