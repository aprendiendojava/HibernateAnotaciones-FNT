INSERT INTO employee( id, first_name, last_name, office, is_off_work ) VALUES ( 1, 'F', 'NT', 'Sevilla', 'Y');
INSERT INTO employee( id, first_name, last_name, office, is_off_work ) VALUES ( 2, 'F', 'NT', 'Sevilla', 'N');
INSERT INTO time_off_work( id, start_date, end_date, employee_id ) VALUES ( 1, '2016-03-04 00:00:00', null, 1 );
INSERT INTO time_off_work( id, start_date, end_date, employee_id ) VALUES ( 2, '2015-10-02 00:00:00', '2015-10-15 00:00:00', 2 );