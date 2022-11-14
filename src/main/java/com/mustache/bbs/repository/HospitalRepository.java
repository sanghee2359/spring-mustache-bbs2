package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);

    List<Hospital> findByRoadNameAddressContaining(String keyword); // 포함

    List<Hospital> findByHospitalNameStartingWith(String keyword); // 시작

    List<Hospital> findByHospitalNameEndingWith(String keyword); // 끝남
    List<Hospital> findByTotalNumberOfBedsBetween(int start,int end);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b);
}
