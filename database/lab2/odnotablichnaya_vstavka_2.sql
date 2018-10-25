INSERT INTO journal (time_out, auto_id, route_id)
VALUES('now', (SELECT id 
		FROM auto
		WHERE color = 'жёлтый' AND personnel_id = 
			(SELECT id
			FROM auto_personnel
			WHERE last_name = 'Шаглина'
			)), 
	   	(SELECT id
		  FROM routes
		  WHERE id = 4));
