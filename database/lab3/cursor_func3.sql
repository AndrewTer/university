CREATE OR REPLACE FUNCTION func3(IN var3 integer, IN var1 text, IN var2 text) 
RETURNS text 
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
$$ 
LANGUAGE plpython3u;

SELECT * FROM func3(13400, '2017-12-12', '2020-12-12');
