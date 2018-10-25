SELECT COUNT(auto.id)
FROM auto, journal
WHERE auto.id = journal.auto_id 
AND journal.route_id =
	( SELECT id
	  FROM routes
	  WHERE name = 'Автово-Ладожская'
	)
