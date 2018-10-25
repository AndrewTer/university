/*
Создать триггер, который не позволит установить время прибытия журнала оператора меньше, чем время отправки
*/

-- Создание триггерной функции
CREATE OR REPLACE FUNCTION no_time_in_less_than_time_out() RETURNS trigger AS $fourth_update$
BEGIN
	IF ((NEW.time_in < OLD.time_out) OR (OLD.time_in < NEW.time_out))  THEN
		RAISE 'Время прибытия не может быть меньше времени отправки!';
		return OLD;
	ELSE
		return NEW;
	END IF;
END;
$fourth_update$  LANGUAGE  plpgsql;

CREATE TRIGGER fourth_update
BEFORE UPDATE
ON journal
FOR EACH ROW 
EXECUTE PROCEDURE no_time_in_less_than_time_out();
