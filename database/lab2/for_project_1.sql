SELECT MIN(journal.time_in-journal.time_out) AS min_time, auto.num 
FROM journal, auto
WHERE route_id =
	( SELECT id
	  FROM routes
	  WHERE name = 'Автово-Ладожская'
	)
	AND auto.id = journal.auto_id
GROUP BY auto.num
LIMIT 1
