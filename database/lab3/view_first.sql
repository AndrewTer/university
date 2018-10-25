/*
Создать представление, отображающее всех водителей
*/

CREATE OR REPLACE VIEW first_v
AS SELECT first_name, last_name FROM auto_personnel;
