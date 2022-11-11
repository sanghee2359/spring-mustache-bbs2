package com.mustache.bbs.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="nation_wide_hospital")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String hospital_name;
    private String full_address;
    public Hospital(String hospital_name, String full_address) {
        this.hospital_name = hospital_name;
        this.full_address = full_address;
    }

}
