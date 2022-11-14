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

    @Column(name="road_name_address")
    private String roadNameAddress;

    private Integer patientRoomCount;
    private String businessTypeName;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

}
