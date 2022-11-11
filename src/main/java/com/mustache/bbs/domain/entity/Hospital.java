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
    // @GeneratedValued 안씀
    private Integer id; // big int
    @Column(name="hospital_name") // 기본 값 말고 다른 형태로 되어있는 경우 Column 사용
    private String hospitalName;
    
    
    private String roadNameAddress;
    public Hospital(String hospital_name, String full_address) {
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }

}
