drop table if exits student_enquiry;

CREATE TABLE student_enquiry (
    student_id INT NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(20),
    student_course_name VARCHAR(24),
    student_exp INT,
    PRIMARY KEY (student_id)
);
-- this is not support in intellij community edition sorry
