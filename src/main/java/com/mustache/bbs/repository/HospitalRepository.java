package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBussinessTypeNameIn(List<String> businessTypes);

}
