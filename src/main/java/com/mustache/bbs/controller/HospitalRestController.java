package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.domain.entity.Hospital;
import com.mustache.bbs.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // json형태로 제공하려면?
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {
    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {

        this.hospitalService = hospitalService;
    }
    @GetMapping("/{id}") // responseEntity<HospitalResponse로 제공한다.
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        /*Optional<Hospital> hospital = hospitalService.getHospital(id); //entity
        return ResponseEntity.ok().body(Hospital.of(hospital.get())); // dto*/
        // return은 dto로 한다.
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
