/*
Создать триггер, который не позволяет добавить автомобиль с номером, который уже есть в парке
*/

-- Создание триггерной функции  
CREATE OR REPLACE FUNCTION insert_auto_by_num () RETURNS trigger AS $first_insert$ 
BEGIN 
if (SELECT Count(*) FROM auto WHERE NEW.num = num) = 0
then 
return NEW;
else
RAISE 'Уже есть автомобиль с таким номером';
return OLD;
end if;
END; 
$first_insert$  LANGUAGE  plpgsql;

CREATE TRIGGER first_insert
 BEFORE INSERT
 ON auto
 for each row
 EXECUTE PROCEDURE insert_auto_by_num();
