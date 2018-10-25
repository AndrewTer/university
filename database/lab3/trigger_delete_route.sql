/*
Создать триггер, который при удалении маршрута в случае наличия на него ссылок откатывает транзакцию
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION delete_route() RETURNS trigger AS $first_delete$
BEGIN
	IF EXISTS(SELECT * FROM journal WHERE route_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этот маршрут!';
	END IF;
	RAISE NOTICE 'Маршрут успешно удалён!';
	RETURN OLD;
END;
$first_delete$  LANGUAGE  plpgsql;


CREATE TRIGGER first_delete
BEFORE DELETE
ON routes
FOR EACH ROW
EXECUTE PROCEDURE delete_route();
