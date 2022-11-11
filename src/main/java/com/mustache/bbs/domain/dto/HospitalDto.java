package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HospitalDto {
    private int id;
    private String hospital_name;
    private String full_address;
    public Hospital toEntity () {
        return new Hospital(this.id, this.hospital_name ,this.full_address);
    }
}
