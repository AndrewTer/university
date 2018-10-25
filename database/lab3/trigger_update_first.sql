/*
Создать триггер, не позволяющий изменить номер автомобиля
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION no_change_auto_num() RETURNS trigger AS $first_update$
BEGIN
IF (OLD.num != NEW.num) then
		RAISE 'Нельзя менять номер автомобиля!';
		return OLD;
	END IF;
END;
$first_update$  LANGUAGE  plpgsql;

CREATE TRIGGER first_update
BEFORE UPDATE
ON auto
FOR EACH ROW 
EXECUTE PROCEDURE no_change_auto_num();
