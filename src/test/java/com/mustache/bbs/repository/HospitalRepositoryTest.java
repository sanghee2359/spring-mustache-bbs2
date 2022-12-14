package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void orderBy() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10, 20);
        for (var hospital : hospitals) {
            System.out.printf("%s | %d\n", hospital.getHospitalName(), hospital.getPatientRoomCount());
        }
    }
    @Test
    void between() { // 가독성 사용성이 훨씬 괜찮다.
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 20);
        for (var hospital : hospitals) {
            System.out.printf("%s | %d\n", hospital.getHospitalName(), hospital.getTotalNumberOfBeds());
        }
    }
    @Test
    void startWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartingWith("연세%");
        for (var hospital : hospitals) {
            System.out.printf("%s \n", hospital.getHospitalName());
        }
    }
    @Test
    void endWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndingWith("%한의원");
        for (var hospital : hospitals) {
            System.out.printf("%s \n", hospital.getHospitalName());
        }
    }
    @Test
    void containing(){
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("강남구");
        for (var hospital : hospitals) {
            System.out.printf("%s | %s\n", hospital.getHospitalName(), hospital.getRoadNameAddress());
        }
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (var hospital :
                hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }
    @Test
    void name(){
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }
}