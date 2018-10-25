/*
Создать представление, отображающее все маршруты и количество автомобилей, находящихся на каждом маршруте
*/

CREATE OR REPLACE VIEW second_v
AS SELECT routes.name, Count(journal.auto_id) 
FROM routes FULL JOIN journal
ON routes.id = journal.route_id
WHERE journal.time_in IS NULL
GROUP BY routes.name;
