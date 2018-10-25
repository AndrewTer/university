SELECT name
FROM routes
WHERE id IN
	( SELECT route_id
	  FROM journal
	  WHERE time_in is null)
