CREATE TABLE JOURNAL (ID integer PRIMARY KEY, TIME_OUT timestamp(3), TIME_IN timestamp(3), 
					AUTO_ID integer references AUTO(ID), ROUTE_ID integer references ROUTES(ID))
