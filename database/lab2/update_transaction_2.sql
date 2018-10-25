BEGIN TRANSACTION;
DO $$
	DECLARE
		oldid INTEGER := 11;
		newid INTEGER := 1;
	BEGIN
		UPDATE journal SET route_id = newid WHERE route_id = oldid;
		DELETE FROM routes WHERE id = oldid;
	END$$;
ROLLBACK;
