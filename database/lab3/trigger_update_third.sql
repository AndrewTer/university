/*
Создать триггер, который при изменении маршрута, в случае наличии ссылок из журнала делает новый маршрут,
хранящий неизмененный (прежний) вариант маршрута и подменять все ссылки на него.
Таким образом, старые записи журнала будут по-прежнему ссылаться на маршрут, по которому они были созданы.
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION create_new_route_when_change_old_route() RETURNS trigger AS $third_update$
DECLARE 
    change_id integer; 
BEGIN
	IF EXISTS(SELECT * FROM journal WHERE route_id = OLD.id) THEN
		--Заносим в переменную максимальный id маршрута
		SELECT MAX(id) INTO change_id FROM routes;
		change_id = change_id + 1;
		RAISE NOTICE 'Имеются ссылки на этот маршрут!';
		--Создаём новый маршрут с максимальным id
		INSERT INTO routes(id, name) VALUES(change_id, NEW.name);
		RAISE NOTICE 'Добавлен новый маршрут с id = %', change_id;
		--Переносим все записи таблицы "Журнал" со старого маршрута на новый
		UPDATE journal SET route_id = change_id WHERE route_id = NEW.id;
		RAISE NOTICE 'Все записи таблица ЖУРНАЛ перенесены со старого маршрута на новый!';
		RETURN OLD;
	ELSE
		RAISE NOTICE 'Маршрут успешно изменён!';
		RETURN NEW;
	END IF;
END;
$third_update$  LANGUAGE  plpgsql;

CREATE TRIGGER third_update
BEFORE UPDATE
ON routes
FOR EACH ROW 
EXECUTE PROCEDURE create_new_route_when_change_old_route();
