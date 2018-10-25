/*
Создать триггер, который при удалении автомобиля в случае наличия на него ссылок откатывает транзакцию
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION delete_auto() RETURNS trigger AS $second_delete$
BEGIN
	IF EXISTS(SELECT * FROM journal WHERE auto_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этот автомобиль!';
	END IF;
	RAISE NOTICE 'Автомобиль успешно удалён!';
	RETURN OLD;
END;
$second_delete$  LANGUAGE  plpgsql;

CREATE TRIGGER second_delete
BEFORE DELETE
ON auto
FOR EACH ROW
EXECUTE PROCEDURE delete_auto();
