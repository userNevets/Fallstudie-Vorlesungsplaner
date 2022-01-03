
CREATE TABLE public.course (
	id bigserial NOT NULL,
	course_name varchar(255) NULL,
	degree_program bytea NULL,
	end_date date NULL,
	start_date date NULL,
	CONSTRAINT course_pkey PRIMARY KEY (id)
);

CREATE TABLE public.course_degree (
	course_id int8 NOT NULL,
	degree_id int8 NOT NULL,
	CONSTRAINT course_degree_pkey PRIMARY KEY (course_id, degree_id)
);

CREATE TABLE public.course_lectures (
	course_id int8 NOT NULL,
	lecture_id int8 NOT NULL,
	CONSTRAINT course_lectures_pkey PRIMARY KEY (course_id, lecture_id),
	CONSTRAINT uk_4b0pq202fgkwmb2np5h4ux7s5 UNIQUE (lecture_id)
);

CREATE TABLE public.course_semester (
	course_id int8 NOT NULL,
	semester_id int8 NOT NULL,
	CONSTRAINT course_semester_pkey PRIMARY KEY (course_id, semester_id),
	CONSTRAINT uk_sd6t5ciovk405m2gq4pvs2ndd UNIQUE (semester_id)
);

CREATE TABLE public.degree_course (
	degree_id int8 NOT NULL,
	course_id int8 NOT NULL,
	CONSTRAINT degree_course_pkey PRIMARY KEY (degree_id, course_id),
	CONSTRAINT uk_h774qrq7r0xcod5omma66bj0e UNIQUE (course_id)
);

CREATE TABLE public.degree_program (
	deg_id bigserial NOT NULL,
	"name" varchar(255) NULL,
	short_name varchar(255) NULL,
	CONSTRAINT degree_program_pkey PRIMARY KEY (deg_id)
);

CREATE TABLE public.lecture (
	lecture_id bigserial NOT NULL,
	course bytea NULL,
	duration int8 NULL,
	lecture_name varchar(255) NULL,
	modul_name varchar(255) NULL,
	id int8,
	CONSTRAINT lecture_pkey PRIMARY KEY (lecture_id)
);

CREATE TABLE public.lecture_date (
	id bigserial NOT NULL,
	lecture bytea NULL,
	end_date timestamp NULL,
	lecturer bytea NULL,
	start_date timestamp NULL,
	lecture_id int8 NOT NULL,
	CONSTRAINT lecture_date_pkey PRIMARY KEY (id)
);

CREATE TABLE public.lecture_date_lecturer (
	lecture_date_id int8 NOT NULL,
	lecturer_id int8 NOT NULL,
	CONSTRAINT lecture_date_lecturer_pkey PRIMARY KEY (lecture_date_id, lecturer_id)
);

CREATE TABLE public.lecture_lecture_dates (
	lecture_id int8 NOT NULL,
	lecture_dates_id int8 NOT NULL,
	CONSTRAINT lecture_lecture_dates_pkey PRIMARY KEY (lecture_id, lecture_dates_id),
	CONSTRAINT uk_4aple1wkdjny2feb7kq6veail UNIQUE (lecture_dates_id)
);

CREATE TABLE public.lecture_lectures (
	lecture_id int8 NOT NULL,
	lecturer_id int8 NOT NULL,
	CONSTRAINT lecture_lectures_pkey PRIMARY KEY (lecture_id, lecturer_id)
);

CREATE TABLE public.lecturer (
	id bigserial NOT NULL,
	last_name varchar(255) NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	lecture1_id int8 NULL,
	CONSTRAINT lecturer_pkey PRIMARY KEY (id)
);

CREATE TABLE public.lecturer_lecture1 (
	lecturer_id int8 NOT NULL,
	lecture1_id int8 NOT NULL,
	CONSTRAINT lecturer_lecture1_pkey PRIMARY KEY (lecturer_id, lecture1_id)
);

CREATE TABLE public.lecturer_lectures (
	lecturer_id int8 NOT NULL,
	lecture_id int8 NOT NULL,
	CONSTRAINT lecturer_lectures_pkey PRIMARY KEY (lecturer_id, lecture_id)
);

CREATE TABLE public."role" (
	id bigserial NOT NULL,
	role_name varchar(255) NULL,
	role_uid varchar(255) NULL,
	CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE public.role_uni_user (
	role_id int8 NOT NULL,
	uni_user_id int8 NOT NULL,
	CONSTRAINT role_uni_user_pkey PRIMARY KEY (role_id, uni_user_id)
);

CREATE TABLE public.semester (
	id bigserial NOT NULL,
	course bytea NULL,
	end_date date NULL,
	"name" varchar(255) NULL,
	"number" int4 NULL,
	semester_number int8 NULL,
	start_date date NULL,
	CONSTRAINT semester_pkey PRIMARY KEY (id)
);

CREATE TABLE public.uni_user (
	id bigserial NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	email varchar(255) NULL,
	CONSTRAINT uni_user_pkey PRIMARY KEY (id)
);

CREATE TABLE public.uni_user_role (
	uni_user_id int8 NOT NULL,
	role_id int8 NOT NULL,
	CONSTRAINT uni_user_role_pkey PRIMARY KEY (uni_user_id, role_id)
);

ALTER TABLE public.uni_user_role ADD CONSTRAINT fk8q34n5u6x5v29eb9wxksw0wmq FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE public.uni_user_role ADD CONSTRAINT fkcrpdgkkpdql0xdkcqsr2qmulp FOREIGN KEY (uni_user_id) REFERENCES uni_user(id);
ALTER TABLE public.course_degree ADD CONSTRAINT fkasd5q8u1nhr24e42gje5n5g0n FOREIGN KEY (degree_id) REFERENCES degree_program(deg_id);
ALTER TABLE public.course_degree ADD CONSTRAINT fkcxb2pj6rduuwpfxeqlxys4lf8 FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE public.semester ADD CONSTRAINT fkc8hcqc07xi06ux8e3hwcthu5y FOREIGN KEY (id) REFERENCES course(id);
ALTER TABLE public.role_uni_user ADD CONSTRAINT fk9tqdbewvo06gyi0nvo4v2jpx8 FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE public.role_uni_user ADD CONSTRAINT fkr84nmb3u9pc8dk6wmnpa4eio9 FOREIGN KEY (uni_user_id) REFERENCES uni_user(id);
ALTER TABLE public.lecturer_lectures ADD CONSTRAINT fkfbnq7d5ooqfhdb4nmi0ncfngv FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecturer_lectures ADD CONSTRAINT fkti6ak9vaed3fe0inoancqg72i FOREIGN KEY (lecturer_id) REFERENCES lecturer(id);
ALTER TABLE public.lecturer_lecture1 ADD CONSTRAINT fk6jc2escm7y6lviwryba96gmhl FOREIGN KEY (lecturer_id) REFERENCES lecturer(id);
ALTER TABLE public.lecturer_lecture1 ADD CONSTRAINT fkt7fycuoil4829gmhj5t87y9mc FOREIGN KEY (lecture1_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecturer ADD CONSTRAINT fk992x5vuoudmbnyj3o27vxglhs FOREIGN KEY (lecture1_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecture_lectures ADD CONSTRAINT fkbu395rjiafu31yf7jau19aly6 FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecture_lectures ADD CONSTRAINT fksgtif8id4gsrvqkg2etbyuf0m FOREIGN KEY (lecturer_id) REFERENCES lecturer(id);
ALTER TABLE public.lecture_date_lecturer ADD CONSTRAINT fkg43utkayqt0wbyagbusn79uvx FOREIGN KEY (lecturer_id) REFERENCES lecturer(id);
ALTER TABLE public.lecture_date_lecturer ADD CONSTRAINT fkv91yod380xagif2hasgjw120 FOREIGN KEY (lecture_date_id) REFERENCES lecture_date(id);
ALTER TABLE public.lecture_lecture_dates ADD CONSTRAINT fkch4gkbs1mnn2k3acqslnud07t FOREIGN KEY (lecture_dates_id) REFERENCES lecture_date(id);
ALTER TABLE public.lecture_lecture_dates ADD CONSTRAINT fkn2gek694324xnq0d9kbpppum0 FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecture_date ADD CONSTRAINT fktfh1908jmya4iug6ouhtmrwdf FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.lecture ADD CONSTRAINT fkp5oy1a1kf9rspnmsj69gkfbbr FOREIGN KEY (id) REFERENCES course(id);
ALTER TABLE public.degree_course ADD CONSTRAINT fk4evqq9y4llvr609tqqqrh4f5r FOREIGN KEY (degree_id) REFERENCES degree_program(deg_id);
ALTER TABLE public.degree_course ADD CONSTRAINT fk74ncsr39jgk9duorvgnvblwgy FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE public.course_semester ADD CONSTRAINT fk24ine28voavuawhlp72ogeu64 FOREIGN KEY (semester_id) REFERENCES semester(id);
ALTER TABLE public.course_semester ADD CONSTRAINT fkqo728e9f9aj1bne0m40nbkuwo FOREIGN KEY (course_id) REFERENCES course(id);
ALTER TABLE public.course_lectures ADD CONSTRAINT fkd8pqvc4yi79r2fgpto1funwxq FOREIGN KEY (lecture_id) REFERENCES lecture(lecture_id);
ALTER TABLE public.course_lectures ADD CONSTRAINT fkpgifj3ifi74q44y4ul80o3hjb FOREIGN KEY (course_id) REFERENCES course(id);

