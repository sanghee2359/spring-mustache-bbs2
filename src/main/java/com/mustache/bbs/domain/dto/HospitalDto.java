package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HospitalDto {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    public Hospital toEntity () {
        return new Hospital(this.id, this.hospitalName ,this.roadNameAddress);
    }
}
