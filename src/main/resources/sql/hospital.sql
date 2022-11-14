/*
 경기도 수원시에 있는 피부과 출력하기
 */
SELECT hospital_name, road_name_address FROM `like-lion-db`.nation_wide_hospital WHERE road_name_address LIKE '경기도 수원시%' and hospital_name LIKE '%피부과%';

/*
 특정 구의 보건소, 보건지소 찾기
 */
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소','보건진료소');

/*
 in, and 모두 사용하기
 */
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
and road_name_address LIKE '경기도 수원시%';

/*
 between 사용하기 - 병상 수가 10개 이상 20개 미만의 병원을 모두 찾습니다.
 */
SELECT hospital_name
FROM `likelion-db`.nation_wide_hospitals
where total_number_of_beds between 10 and 20;
/*
 orderBy 사용하기 - desc는 오름차순, asc는 내림차순
 */
SELECT hospital_name, patient_room_count FROM `like-lion-db`.nation_wide_hospitals
where patient_room_count between 1 and 3
order by patient_room_count desc;