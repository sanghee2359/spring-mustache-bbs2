SELECT *
FROM(SELECT * FROM `like-lion-db`.nation_wide_hospital WHERE road_name_address LIKE '경기도 수원시%') WHERE hospital_name LIKE '%피부%';