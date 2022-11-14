/*
 경기도 수원시에 있는 피부과 출력하기
 */
SELECT hospital_name, road_name_address FROM `like-lion-db`.nation_wide_hospital WHERE road_name_address LIKE '경기도 수원시%' and hospital_name LIKE '%피부과%';

/*
 특정 구의 보건소, 보건지소 찾기
 */
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
;