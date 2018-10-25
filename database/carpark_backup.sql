--
-- PostgreSQL database dump
--

-- Dumped from database version 10.2
-- Dumped by pg_dump version 10.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
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


SET search_path = public, pg_catalog;

--
-- Name: auto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: auto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE auto (
    id integer DEFAULT nextval('auto_seq'::regclass) NOT NULL,
    num character varying(20),
    color character varying(20),
    mark character varying(20),
    personnel_id integer
);


ALTER TABLE auto OWNER TO postgres;

--
-- Name: auto_personnel_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE auto_personnel_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auto_personnel_seq OWNER TO postgres;

--
-- Name: auto_personnel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE auto_personnel (
    id integer DEFAULT nextval('auto_personnel_seq'::regclass) NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    pather_name character varying(20)
);


ALTER TABLE auto_personnel OWNER TO postgres;

--
-- Name: journal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE journal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE journal_seq OWNER TO postgres;

--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE journal (
    id integer DEFAULT nextval('journal_seq'::regclass) NOT NULL,
    time_out timestamp(3) with time zone,
    time_in timestamp(3) with time zone,
    auto_id integer,
    route_id integer
);


ALTER TABLE journal OWNER TO postgres;

--
-- Name: journal_s; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE journal_s
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE journal_s OWNER TO postgres;

--
-- Name: routes_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE routes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE routes_seq OWNER TO postgres;

--
-- Name: routes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE routes (
    id integer DEFAULT nextval('routes_seq'::regclass) NOT NULL,
    name character varying(50)
);


ALTER TABLE routes OWNER TO postgres;

--
-- Data for Name: auto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY auto (id, num, color, mark, personnel_id) FROM stdin;
2	A849MP	чёрный	Ford Tourneo Custom	8
1	P173OK	красный	ГАЗ-3302	2
3	E993KX	белый	ГАЗ-2705	4
7	E029PE	чёрный	ГАЗ-3221	5
4	K902YN	серебристый	Mercedes-Benz Vito	3
8	K991OM	красный	Ford Transit	7
10	E582OK	синий	Mercedes-Benz Sprint	9
6	P632MM	синий	Mercedes-Benz Sprint	1
9	H243PO	серый	ГАЗ-2705	1
22	K231EM	белый	ГАЗ-3302	10
5	K772MA	жёлтый	ГАЗ-3303	6
23	A782MK	жёлтый	Ford Transit	10
\.


--
-- Data for Name: auto_personnel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY auto_personnel (id, first_name, last_name, pather_name) FROM stdin;
1	Иван	Назаров	Константинович
2	Максим	Сивач	Валентинович
3	Кирилл	Зуза	Сергеевич
4	Роман	Дубаков	Артёмович
5	Анастасия	Елагина	Михайловна
6	Кристина	Лаврова	Николаевна
7	Денис	Столяров	Иванович
8	Глеб	Савичев	Романович
9	Евгения	Дроздова	Андреевна
10	Екатерина	Шаглина	Максимовна
\.


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY journal (id, time_out, time_in, auto_id, route_id) FROM stdin;
1	2018-06-04 11:00:00+03	2018-06-04 12:30:00+03	5	3
3	2018-07-07 12:19:00+03	\N	3	2
5	2018-07-08 19:45:00+03	2018-07-09 01:20:00+03	1	1
6	2018-02-27 17:18:10.534+03	\N	10	4
8	2018-02-27 17:29:54.083+03	\N	23	4
4	2018-02-27 15:20:00+03	2018-02-27 17:55:35.309+03	6	4
2	2018-06-05 17:45:00+03	2018-06-05 19:34:00+03	2	5
\.


--
-- Data for Name: routes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY routes (id, name) FROM stdin;
2	Волосово-Балтийский вокзал
1	Автово-Ладожская
3	Ручьи-Литейный проспект
4	Бестужевская-Садовая
5	ТРК Пик-ст.м.Политехническая
\.


--
-- Name: auto_personnel_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('auto_personnel_seq', 10, true);


--
-- Name: auto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('auto_seq', 23, true);


--
-- Name: journal_s; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_s', 1, false);


--
-- Name: journal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_seq', 8, true);


--
-- Name: routes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('routes_seq', 9, true);


--
-- Name: auto_personnel auto_personnel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto_personnel
    ADD CONSTRAINT auto_personnel_pkey PRIMARY KEY (id);


--
-- Name: auto auto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: routes routes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY routes
    ADD CONSTRAINT routes_pkey PRIMARY KEY (id);


--
-- Name: auto auto_personnel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY auto
    ADD CONSTRAINT auto_personnel_id_fkey FOREIGN KEY (personnel_id) REFERENCES auto_personnel(id);


--
-- Name: journal journal_auto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_auto_id_fkey FOREIGN KEY (auto_id) REFERENCES auto(id);


--
-- Name: journal journal_route_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_route_id_fkey FOREIGN KEY (route_id) REFERENCES routes(id);


--
-- PostgreSQL database dump complete
--

