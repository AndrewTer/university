DELETE FROM auto_personnel
WHERE id NOT IN (
	SELECT auto.personnel_id
	FROM auto, auto_personnel
	WHERE auto_personnel.id = auto.personnel_id
);
