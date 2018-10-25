/*
Создать триггер, который не позволит изменить маршрут, в котором есть незаконченные рейсы
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION no_change_route_with_unfinished_trip() RETURNS trigger AS $second_update$
BEGIN
	IF (SELECT Count(journal.id) FROM journal, routes WHERE (journal.route_id = routes.id) AND (journal.time_in is null) AND (routes.id = OLD.id)) > 0 then
		RAISE 'У этого маршрута есть незаконченные рейсы!';
		return OLD;
	ELSE
		return NEW;
	END IF;
END;
$second_update$  LANGUAGE  plpgsql;

CREATE TRIGGER second_update
BEFORE UPDATE
ON routes
FOR EACH ROW 
EXECUTE PROCEDURE no_change_route_with_unfinished_trip();
