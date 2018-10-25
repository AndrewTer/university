/*
Создать хранимую процедуру с входным параметром маршрут и двумя выходными параметрами, 
возвращающими самое короткое время проезда по заданному маршруту и автомобиль, 
поставивший рекорд
*/

CREATE OR REPLACE FUNCTION proc_third (name_route varchar(50))
returns table(Самое_короткое_время_по_маршруту interval, Автомобиль varchar(20)) AS
$body$ 
begin
    return query SELECT MIN(journal.time_in - journal.time_out), auto.num
  FROM journal, routes, auto
  WHERE (routes.id = journal.route_id) AND (journal.auto_id = auto.id) AND (routes.name = name_route)
  GROUP BY journal.time_in - journal.time_out, auto.num
  LIMIT 1;
end;
$body$ 
LANGUAGE 'plpgsql';

SELECT * FROM proc_third('Автово-Ладожская');
