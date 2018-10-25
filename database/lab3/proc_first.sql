-- Создать хранимую процедуру, выводящую все маршруты и среднее время проезда по ним в минутах

CREATE OR REPLACE FUNCTION proc_first ()
returns table(Маршрут varchar(50), Среднее_время_в_минутах double precision) AS
$body$ 
begin
    return query SELECT routes.name, avg(extract(epoch from (journal.time_in - journal.time_out)))/60
				FROM routes, journal
				WHERE routes.id = journal.route_id
				GROUP BY routes.name;
end;
$body$ 
LANGUAGE 'plpgsql';

select * from proc_first();
