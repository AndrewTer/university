UPDATE journal
SET route_id = 5
WHERE auto_id = (
	SELECT id
	FROM auto
	WHERE num = 'A849MP'
);
