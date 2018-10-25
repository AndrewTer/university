INSERT INTO auto (num, color, mark, personnel_id)
VALUES('K231EM', 'белый', 'ГАЗ-3302', (SELECT id FROM auto_personnel WHERE last_name = 'Шаглина')),
('A782MK', 'синий', 'Ford Transit', (SELECT id FROM auto_personnel WHERE last_name = 'Шаглина'))
