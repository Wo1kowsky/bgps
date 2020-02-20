CREATE TABLE exam_type
(
id INT NOT NULL,
type TEXT NULL
);

ALTER TABLE exam_type
ADD PRIMARY KEY (id);

CREATE TABLE journal
(
id INT NOT NULL,
study_plan_id INT NOT NULL,
mark_id INT NOT NULL,
journal_id INT NOT NULL,
count INT NULL,
in_time BIT NULL
);

ALTER TABLE journal
ADD PRIMARY KEY (id);

CREATE TABLE mark
(
id INT NOT NULL,
name TEXT NULL,
value TEXT NULL
);

ALTER TABLE mark
ADD PRIMARY KEY (id);

CREATE TABLE student
(
id INT NOT NULL,
study_group_id INT NOT NULL,
surname TEXT NULL,
name TEXT NULL,
second_name TEXT NULL
);

ALTER TABLE student
ADD PRIMARY KEY (id);

CREATE TABLE study_group
(
id INT NOT NULL,
name TEXT NULL
);

ALTER TABLE study_group
ADD PRIMARY KEY (id);

CREATE TABLE study_plan
(
id INT NOT NULL,
exam_type_id INT NOT NULL,
subject_id INT NOT NULL
);

ALTER TABLE study_plan
ADD PRIMARY KEY (id);

CREATE TABLE subject
(
id INT NOT NULL,
name TEXT NULL,
short_name TEXT NULL
);

ALTER TABLE subject
ADD PRIMARY KEY (id);

ALTER TABLE journal
ADD CONSTRAINT R_1 FOREIGN KEY (journal_id) REFERENCES student (id);

ALTER TABLE journal
ADD CONSTRAINT R_2 FOREIGN KEY (mark_id) REFERENCES mark (id);

ALTER TABLE journal
ADD CONSTRAINT R_3 FOREIGN KEY (study_plan_id) REFERENCES study_plan (id);

ALTER TABLE student
ADD CONSTRAINT R_4 FOREIGN KEY (study_group_id) REFERENCES study_group (id);

ALTER TABLE study_plan
ADD CONSTRAINT R_5 FOREIGN KEY (subject_id) REFERENCES subject (id);

ALTER TABLE study_plan
ADD CONSTRAINT R_6 FOREIGN KEY (exam_type_id) REFERENCES exam_type (id);

INSERT INTO subject (id, name, short_name) VALUES
(1, 'Проектирование информационных систем', 'ПрИС'),
(2, 'Системы искусственного интеллекта', 'СИИ'),
(3, 'Программная инженерия', 'ПИ'),
(4, 'Национальная система информационной безопасности', 'НСИБ'),
(5, 'Системный анализ', 'СА'),
(6, 'Распределенные базы данных', 'РБД'),
(7, 'Системное программное обеспечение', 'СПО');

INSERT INTO exam_type (id, type) VALUES
(1, 'Экзамен'),
(2, 'Зачет'),
(3, 'Зачет с оценкой'),
(4, 'Курсовая');

INSERT INTO study_plan (id, subject_id, exam_type_id) VALUES
(1, 1, 1),
(2, 1, 4),
(3, 2, 1),
(4, 3, 1),
(5, 4, 2),
(6, 5, 1),
(7, 6, 2),
(8, 7, 1);

INSERT INTO mark (id, name, value) VALUES
(1, 'Отлично', 5),
(2, 'Хорошо', 4),
(3, 'Удовлетворительно', 3),
(4, 'Неудовлетворительно', 2),
(5, 'Зачет', 'з'),
(6, 'Незачет', 'н'),
(7, 'Неявка', '');