SELECT num
FROM auto
WHERE personnel_id =
	( SELECT id
	  FROM auto_personnel
	  WHERE last_name = 'Назаров');
