CREATE TABLE AUTO (ID integer PRIMARY KEY, NUM varchar(20), COLOR varchar(20), MARK varchar(20), 
				PERSONNEL_ID integer references AUTO_PERSONNEL(ID))
