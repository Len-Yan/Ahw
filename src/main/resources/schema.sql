


CREATE TABLE IF NOT EXISTS student( id INT PRIMARY KEY AUTO_INCREMENT, firstname VARCHAR(50), lastname VARCHAR(50));
CREATE TABLE IF NOT EXISTS teacher( id INT PRIMARY KEY AUTO_INCREMENT, firstname VARCHAR(50), lastname VARCHAR(50));
CREATE TABLE IF NOT EXISTS student_teacher(id INT PRIMARY KEY AUTO_INCREMENT,
                            student_id INT, teacher_id INT,
                            CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id),
                            CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id));