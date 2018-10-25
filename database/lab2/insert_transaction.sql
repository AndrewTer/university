START TRANSACTION;
DO $$
	DECLARE
		routeid INTEGER := 1;
	BEGIN
		IF (SELECT COUNT(auto_id) > 2  FROM journal WHERE route_id = routeid) THEN
			INSERT INTO journal(time_out, auto_id, route_id) VALUES('now', 4, routeid);
		END IF;
	END$$;
ROLLBACK;
