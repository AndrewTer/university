/*
Создать триггер, который не позволяет добавить запись в журнал оператора, в которой дата прибытия не NULL
*/

-- Создание триггерной функции  
CREATE OR REPLACE FUNCTION no_insert_entry_without_null() RETURNS trigger AS $second_insert$ 
 BEGIN
 if NEW.time_in is NULL then 
 	RAISE 'Запись успешно добавлена!';
	return NEW;
 else
 	RAISE 'Дата прибытия должна быть NULL!';
	return OLD;
 end if;
 END;
$second_insert$  LANGUAGE  plpgsql;

CREATE TRIGGER second_insert
BEFORE INSERT
ON journal
for each row
EXECUTE PROCEDURE no_insert_entry_without_null();
