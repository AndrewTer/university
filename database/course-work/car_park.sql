--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: plpython3u; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpython3u;


ALTER PROCEDURAL LANGUAGE plpython3u OWNER TO postgres;

--
-- Name: create_new_route_when_change_old_route(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.create_new_route_when_change_old_route() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

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

$$;


ALTER FUNCTION public.create_new_route_when_change_old_route() OWNER TO postgres;

--
-- Name: delete_auto(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_auto() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	IF EXISTS(SELECT * FROM journal WHERE auto_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этот автомобиль!';
	END IF;
	RAISE NOTICE 'Автомобиль успешно удалён!';
	RETURN OLD;
END;
$$;


ALTER FUNCTION public.delete_auto() OWNER TO postgres;

--
-- Name: delete_auto_personnel(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_auto_personnel() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	IF EXISTS(SELECT * FROM auto WHERE personnel_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этого водителя!';
	END IF;
	RAISE NOTICE 'Водитель успешно удалён!';
	RETURN OLD;
END;
$$;


ALTER FUNCTION public.delete_auto_personnel() OWNER TO postgres;

--
-- Name: delete_route(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.delete_route() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	IF EXISTS(SELECT * FROM journal WHERE route_id = OLD.id) THEN
		RAISE exception 'Имеются ссылки на этот маршрут!';
	END IF;
	RAISE NOTICE 'Маршрут успешно удалён!';
	RETURN OLD;
END;
$$;


ALTER FUNCTION public.delete_route() OWNER TO postgres;

--
-- Name: func3(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.func3(var3 integer) RETURNS text
    LANGUAGE plpython3u
    AS $$ 
txt = "" 
dr1 = "" 
dr2 = "" 
dr3 = "" 
a1 = 0 
a2 = 0 
a3 = 0 
for row1 in plpy.cursor("select id from auto_personnel ;"):
	txt = str(row1['id'])
	for row2 in plpy.cursor("select auto_personnel.first_name, auto_personnel.last_name,(select count(*) from journal join auto on journal.auto_id = auto.id join auto_personnel on auto.personnel_id = auto_personnel.id where auto_personnel.id = " + txt + " ) as count from auto_personnel join auto on auto_personnel.id = auto.personnel_id join journal on auto.id = journal.auto_id where journal.id = " + txt + ";"): 
		if a1 < row2['count']: 
			dr3 = dr2 
			dr2 = dr1 
			dr1 = row2['first_name'] + " " + row2['last_name'] 
			a3 = a2 
			a2 = a1 
			a1 = row2['count'] 
		elif a2 < row2['count']: 
			dr3 = dr2 
			dr2 = row2['first_name'] + " " + row2['last_name'] 
			a3 = a2 
			a2 = row2['count'] 
		elif a3 < row2['count']: 
			dr3 = row2['first_name'] + " " + row2['last_name'] 
			a3 = row2['count'] 
a3 = var3 * 0.2 
a2 = var3 * 0.3 
a1 = var3 * 0.5 
txt = dr1 + " " + str(a1) + " | " + dr2 + " " + str(a2) + " | " + dr3 + " " + str(a3) 
return txt 
$$;


ALTER FUNCTION public.func3(var3 integer) OWNER TO postgres;

--
-- Name: func3(date, date); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.func3(var1 date, var2 date) RETURNS text
    LANGUAGE plpython3u
    AS $$ 
txt = "" 
dr1 = "" 
dr2 = "" 
dr3 = "" 
a1 = 0 
a2 = 0 
a3 = 0 
for row in plpy.cursor("select id from auto_personnel"): 
	if a1 < response['count']: 
		dr3 = dr2 
		dr2 = dr1 
		dr1 = response['first_name'] + " " + response['last_name'] 
		a3 = a2 
		a2 = a1 
		a1 = response['count'] 
	elif a2 < response['count']: 
		dr3 = dr2 
		dr2 = response['first_name'] + " " + response['last_name'] 
		a3 = a2 
		a2 = response['count'] 
	elif a3 < response['count']: 
		dr3 = response['first_name'] + " " + response['last_name'] 
		a3 = response['count'] 
		a3 = a3 * 0.2 
		a2 = a2 * 0.3 
		a1 = a1 * 0.5 
	txt = dr1 + " " + str(a1) + " | " + dr2 + " " + str(a2) + " | " + dr3 + " " + str(a3) 
return txt 
$$;


ALTER FUNCTION public.func3(var1 date, var2 date) OWNER TO postgres;

--
-- Name: func3(date, date, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.func3(var1 date, var2 date, var3 integer) RETURNS text
    LANGUAGE plpython3u
    AS $$ 
txt = "" 
dr1 = "" 
dr2 = "" 
dr3 = "" 
a1 = 0 
a2 = 0 
a3 = 0 
for row1 in plpy.cursor("select id from auto_personnel;"): 
	for row2 in plpy.cursor("select auto_personnel.first_name, auto_personnel.last_name,(select count(*) from journal join auto on journal.auto_id = auto.id join auto_personnel on auto.personnel_id = auto_personnel.id where auto_personnel.id = "+str(row1[id])+" AND auto_personnel.time_out < "+str(var2)+" AND auto_personnel.time_in > "+str(var1)+") as count from auto_personnel join auto on auto_personnel.id = auto.personnel_id join journal on auto.id = journal.auto_id where journal.id = "+str(row1[id])+";"): 
		if a1 < response['count']: 
			dr3 = dr2 
			dr2 = dr1 
			dr1 = response['first_name'] + " " + response['last_name'] 
			a3 = a2 
			a2 = a1 
			a1 = response['count'] 
		elif a2 < response['count']: 
			dr3 = dr2 
			dr2 = response['first_name'] + " " + response['last_name'] 
			a3 = a2 
			a2 = response['count'] 
		elif a3 < response['count']: 
			dr3 = response['first_name'] + " " + response['last_name'] 
			a3 = response['count'] 
a3 = var3 * 0.2 
a2 = var3 * 0.3 
a1 = var3 * 0.5 
txt = dr1 + " " + str(a1) + " | " + dr2 + " " + str(a2) + " | " + dr3 + " " + str(a3) 
return txt 
$$;


ALTER FUNCTION public.func3(var1 date, var2 date, var3 integer) OWNER TO postgres;

--
-- Name: func3(integer, text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.func3(var3 integer, var1 text, var2 text) RETURNS text
    LANGUAGE plpython3u
    AS $$ 
txt = "" 
dr1 = "" 
dr2 = "" 
dr3 = "" 
a1 = 0 
a2 = 0 
a3 = 0 
for row1 in plpy.cursor("select id from auto_personnel ;"):
	txt = str(row1['id'])
	for row2 in plpy.cursor("select auto_personnel.first_name, auto_personnel.last_name,(select count(*) from journal join auto on journal.auto_id = auto.id join auto_personnel on auto.personnel_id = auto_personnel.id where auto_personnel.id = " + txt + " ) as count from auto_personnel join auto on auto_personnel.id = auto.personnel_id join journal on auto.id = journal.auto_id where journal.id = " + txt + ";"): 
		if a1 < row2['count']: 
			dr3 = dr2 
			dr2 = dr1 
			dr1 = row2['first_name'] + " " + row2['last_name'] 
			a3 = a2 
			a2 = a1 
			a1 = row2['count'] 
		elif a2 < row2['count']: 
			dr3 = dr2 
			dr2 = row2['first_name'] + " " + row2['last_name'] 
			a3 = a2 
			a2 = row2['count'] 
		elif a3 < row2['count']: 
			dr3 = row2['first_name'] + " " + row2['last_name'] 
			a3 = row2['count'] 
a3 = var3 * 0.2 
a2 = var3 * 0.3 
a1 = var3 * 0.5 
txt = dr1 + " " + str(a1) + " | " + dr2 + " " + str(a2) + " | " + dr3 + " " + str(a3) 
return txt 
$$;


ALTER FUNCTION public.func3(var3 integer, var1 text, var2 text) OWNER TO postgres;

--
-- Name: insert_auto_by_num(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.insert_auto_by_num() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
BEGIN 
if (SELECT Count(*) FROM auto WHERE NEW.num = num) = 0
then 
return NEW;
else
RAISE 'Уже есть автомобиль с таким номером';
return OLD;
end if;
END; 
$$;


ALTER FUNCTION public.insert_auto_by_num() OWNER TO postgres;

--
-- Name: no_change_auto_num(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.no_change_auto_num() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
IF (OLD.num != NEW.num) then
		RAISE 'Нельзя менять номер автомобиля!';
		return OLD;
	END IF;
END;
$$;


ALTER FUNCTION public.no_change_auto_num() OWNER TO postgres;

--
-- Name: no_change_route_with_unfinished_trip(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.no_change_route_with_unfinished_trip() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	IF (SELECT Count(journal.id) FROM journal, routes WHERE (journal.route_id = routes.id) AND (journal.time_in is null) AND (routes.id = OLD.id)) > 0 then
		RAISE 'У этого маршрута есть незаконченные рейсы!';
		return OLD;
	ELSE
		return NEW;
	END IF;
END;
$$;


ALTER FUNCTION public.no_change_route_with_unfinished_trip() OWNER TO postgres;

--
-- Name: no_insert_auto_without_time_in(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.no_insert_auto_without_time_in() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
 BEGIN
 if (SELECT Count(*) FROM journal WHERE (auto_id = NEW.auto_id) AND time_in is NULL) = 0 then 
	return NEW;
 else
 	RAISE 'Этот автомобиль ещё не вернулся!';
	return OLD;
 end if;
 END;
$$;


ALTER FUNCTION public.no_insert_auto_without_time_in() OWNER TO postgres;

--
-- Name: no_insert_entry_without_null(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.no_insert_entry_without_null() RETURNS trigger
    LANGUAGE plpgsql
    AS $$ 
 BEGIN
 if NEW.time_in is NULL then 
 	RAISE 'Запись успешно добавлена!';
	return NEW;
 else
 	RAISE 'Дата прибытия должна быть NULL!';
	return OLD;
 end if;
 END;
$$;


ALTER FUNCTION public.no_insert_entry_without_null() OWNER TO postgres;

--
-- Name: proc_first(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.proc_first() RETURNS TABLE("Маршрут" character varying, "Среднее_время_в_минутах" double precision)
    LANGUAGE plpgsql
    AS $$ 

begin
    return query 
SELECT routes.name, avg(extract(epoch from (journal.time_in - journal.time_out)))/60
		FROM routes, journal
		WHERE routes.id = journal.route_id
		GROUP BY routes.name;
end;

$$;


ALTER FUNCTION public.proc_first() OWNER TO postgres;

--
-- Name: proc_second(character varying, character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.proc_second(auto1 character varying, auto2 character varying) RETURNS TABLE(routes character varying)
    LANGUAGE plpgsql
    AS $$ 
begin
return query SELECT name FROM routes WHERE id = (SELECT route FROM
(SELECT * FROM 
(SELECT journal.route_id AS route, auto_id, journal.time_in - journal.time_out AS col FROM journal
WHERE 
journal.auto_id = (SELECT id FROM auto WHERE num = auto1)
OR 
journal.auto_id = (SELECT id FROM auto WHERE num = auto2)) AS t1
WHERE (auto_id,col) IN 
( SELECT auto_id, MAX(col) FROM 
(SELECT journal.route_id, auto_id, journal.time_in - journal.time_out AS col FROM journal
WHERE 
journal.auto_id = (SELECT id FROM auto WHERE num = auto1) 
OR 
journal.auto_id = (SELECT id FROM auto WHERE num = auto2)) AS t1
GROUP BY auto_id
)
)AS t2 
WHERE auto_id = (SELECT id FROM auto WHERE num = auto1));

end;
$$;


ALTER FUNCTION public.proc_second(auto1 character varying, auto2 character varying) OWNER TO postgres;

--
-- Name: proc_third(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.proc_third(name_route character varying) RETURNS TABLE("Самое_короткое_время_по_маршруту" interval, "Автомобиль" character varying)
    LANGUAGE plpgsql
    AS $$ 

begin
    return query SELECT MIN(journal.time_in - journal.time_out), auto.num
  FROM journal, routes, auto
  WHERE (routes.id = journal.route_id) AND (journal.auto_id = auto.id) AND (routes.name = name_route)
  GROUP BY journal.time_in - journal.time_out, auto.num;
end;

$$;


ALTER FUNCTION public.proc_third(name_route character varying) OWNER TO postgres;

--
-- Name: pymax(integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.pymax(a integer, b integer) RETURNS integer
    LANGUAGE plpython3u
    AS $$
  if a > b:
    return a
  return b
$$;


ALTER FUNCTION public.pymax(a integer, b integer) OWNER TO postgres;

--
-- Name: auto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auto_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: auto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auto (
    id integer DEFAULT nextval('public.auto_seq'::regclass) NOT NULL,
    num character varying(20),
    color character varying(20),
    mark character varying(20),
    personnel_id integer
);


ALTER TABLE public.auto OWNER TO postgres;

--
-- Name: auto_personnel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auto_personnel_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auto_personnel_seq OWNER TO postgres;

--
-- Name: auto_personnel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auto_personnel (
    id integer DEFAULT nextval('public.auto_personnel_seq'::regclass) NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    pather_name character varying(20)
);


ALTER TABLE public.auto_personnel OWNER TO postgres;

--
-- Name: first_v; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.first_v AS
 SELECT auto_personnel.first_name,
    auto_personnel.last_name
   FROM public.auto_personnel;


ALTER TABLE public.first_v OWNER TO postgres;

--
-- Name: journal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.journal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.journal_seq OWNER TO postgres;

--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.journal (
    id integer DEFAULT nextval('public.journal_seq'::regclass) NOT NULL,
    time_out timestamp(3) with time zone,
    time_in timestamp(3) with time zone,
    auto_id integer,
    route_id integer
);


ALTER TABLE public.journal OWNER TO postgres;

--
-- Name: journal_s; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.journal_s
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.journal_s OWNER TO postgres;

--
-- Name: routes_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.routes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.routes_seq OWNER TO postgres;

--
-- Name: routes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.routes (
    id integer DEFAULT nextval('public.routes_seq'::regclass) NOT NULL,
    name character varying(50)
);


ALTER TABLE public.routes OWNER TO postgres;

--
-- Name: second_v; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.second_v AS
 SELECT routes.name,
    count(journal.auto_id) AS count
   FROM (public.routes
     FULL JOIN public.journal ON ((routes.id = journal.route_id)))
  WHERE (journal.time_in IS NULL)
  GROUP BY routes.name;


ALTER TABLE public.second_v OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id bigint NOT NULL,
    name character varying(20),
    password character varying(100),
    title character varying(20)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: auto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auto (id, num, color, mark, personnel_id) FROM stdin;
1	P173OK	красный	ГАЗ-3302	2
2	A849MP\n	чёрный	Ford Tourneo	8
3	E993KX	белый	ГАЗ-2705	4
4	K902YN	серебристый 	Mercedes-Benz	3
5	K772MA	жёлтый	ГАЗ-3303	6
7	E029PE	чёрны	ГАЗ-3221	5
8	K991OM	красный	Ford Transit	7
9	H243PO	серый	ГАЗ-2705	1
10	E582OK	синий	Mrecedes-Benz	2
57	A829MP	красный	Mrecedes-Benz	2
61	P632MM	синий	Mercedes-Benz	1
77	H222PK	White	Subaru	21
\.


--
-- Data for Name: auto_personnel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auto_personnel (id, first_name, last_name, pather_name) FROM stdin;
1	Иван	Назаров	Константинович
2	Максим	Сивач	Валентинович
3	Кирилл	Зуза	Сергеевич
4	Роман	Дубаков	Артёмович
5	Анастасия	Елагина	Михайловна
6	Кристина	Лаврова	Николаевна
7	Денис	Столяров	Иванович
8	Глеб	Савичев	Романович
21	Алексей	Шаров	Аркадьевич
\.


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.journal (id, time_out, time_in, auto_id, route_id) FROM stdin;
4	2018-02-27 15:20:00+03	2018-02-28 17:55:35+03	5	4
3	2018-07-07 00:00:00+03	2018-07-07 18:12:00+03	3	3
6	2018-02-27 17:18:10+03	\N	10	4
5	2018-07-08 19:45:00+03	2018-07-10 01:20:00+03	5	1
12	2018-03-05 13:32:00+03	2018-03-05 15:45:11+03	61	1
11	2018-03-01 11:45:00+03	2018-03-01 14:10:45+03	2	1
59	2018-04-09 11:35:00+03	\N	61	1
15	2018-03-31 19:46:00+03	2018-03-31 20:46:58+03	3	4
69	2018-12-12 12:12:12+03	2018-12-12 22:20:20+03	3	1
70	2016-10-04 15:03:01+03	2016-11-01 10:24:12+03	5	5
\.


--
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.routes (id, name) FROM stdin;
1	Автово-Ладожская
2	Волосово-Балтийский вокзал
3	Ручьи-Литейный проспект
4	Бестужевская-Садовая
5	ТРК Пик-ст.м.Политехническая
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, name, password, title) FROM stdin;
1	user	EE11CBB19052E40B07AAC0CA060C23EE	user
2	admin	41D8B17B7D2ED68DF448E2F85447EC0C	admin
\.


--
-- Name: auto_personnel_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auto_personnel_seq', 22, true);


--
-- Name: auto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auto_seq', 79, true);


--
-- Name: journal_s; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.journal_s', 1, false);


--
-- Name: journal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.journal_seq', 71, true);


--
-- Name: routes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.routes_seq', 25, true);


--
-- Name: auto_personnel auto_personnel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auto_personnel
    ADD CONSTRAINT auto_personnel_pkey PRIMARY KEY (id);


--
-- Name: auto auto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: routes routes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: routes first_delete; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER first_delete BEFORE DELETE ON public.routes FOR EACH ROW EXECUTE PROCEDURE public.delete_route();


--
-- Name: auto first_insert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER first_insert BEFORE INSERT ON public.auto FOR EACH ROW EXECUTE PROCEDURE public.insert_auto_by_num();


--
-- Name: auto first_update; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER first_update BEFORE UPDATE ON public.auto FOR EACH ROW EXECUTE PROCEDURE public.no_change_auto_num();


--
-- Name: auto second_delete; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER second_delete BEFORE DELETE ON public.auto FOR EACH ROW EXECUTE PROCEDURE public.delete_auto();


--
-- Name: journal second_insert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER second_insert BEFORE INSERT ON public.journal FOR EACH ROW EXECUTE PROCEDURE public.no_insert_entry_without_null();


--
-- Name: routes second_update; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER second_update BEFORE UPDATE ON public.routes FOR EACH ROW EXECUTE PROCEDURE public.no_change_route_with_unfinished_trip();


--
-- Name: auto_personnel third_delete; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER third_delete BEFORE DELETE ON public.auto_personnel FOR EACH ROW EXECUTE PROCEDURE public.delete_auto_personnel();


--
-- Name: journal third_insert; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER third_insert BEFORE INSERT ON public.journal FOR EACH ROW EXECUTE PROCEDURE public.no_insert_auto_without_time_in();


--
-- Name: routes third_update; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER third_update BEFORE UPDATE ON public.routes FOR EACH ROW EXECUTE PROCEDURE public.create_new_route_when_change_old_route();


--
-- Name: auto auto_personnel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auto
    ADD CONSTRAINT auto_personnel_id_fkey FOREIGN KEY (personnel_id) REFERENCES public.auto_personnel(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: journal journal_auto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_auto_id_fkey FOREIGN KEY (auto_id) REFERENCES public.auto(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: journal journal_route_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_route_id_fkey FOREIGN KEY (route_id) REFERENCES public.routes(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

