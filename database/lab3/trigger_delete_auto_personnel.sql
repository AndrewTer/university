/*
Создать триггер, который при удалении водителя в случае наличия на него ссылок откатывает транзакцию
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION delete_auto_personnel() RETURNS trigger AS $third_delete$
BEGIN
	IF EXISTS(SELECT * FROM auto WHERE personnel_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этого водителя!';
	END IF;
	RAISE NOTICE 'Водитель успешно удалён!';
	RETURN OLD;
END;
$third_delete$  LANGUAGE  plpgsql;

CREATE TRIGGER third_delete
BEFORE DELETE
ON auto_personnel
FOR EACH ROW
EXECUTE PROCEDURE delete_auto_personnel();
