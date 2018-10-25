START TRANSACTION;
UPDATE journal SET route_id = 1 WHERE route_id = 11;
DELETE FROM routes WHERE id = 11;
COMMIT;
