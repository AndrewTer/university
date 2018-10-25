/*
Создать триггер, который не позволяет отправить в рейс автомобиль, который еще не вернулся в парк
*/

-- Создание триггерной функции  
CREATE OR REPLACE FUNCTION no_insert_auto_without_time_in() RETURNS trigger AS $second_insert$ 
 BEGIN
 if (SELECT Count(*) FROM journal WHERE (auto_id = NEW.auto_id) AND time_in is NULL) = 0 then 
	return NEW;
 else
 	RAISE 'Этот автомобиль ещё не вернулся!';
	return OLD;
 end if;
 END;
$second_insert$  LANGUAGE  plpgsql;

CREATE TRIGGER third_insert
BEFORE INSERT
ON journal
for each row
EXECUTE PROCEDURE no_insert_auto_without_time_in();
