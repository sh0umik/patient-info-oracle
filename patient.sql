create table Patients (
	id int null,
	age int null,
	adate timestamp null,
	ddate timestamp null,
	name varchar2(255) null,
	sex varchar2(65) null,
	address varchar2(65) null,
	contact varchar2(65) null,
	CONSTRAINT p_id PRIMARY KEY (id)
);
