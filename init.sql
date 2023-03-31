CREATE database docker;
USE docker;
CREATE TABLE user(id int , username varchar(50) , password varchar(50));
CREATE TABLE grades(student_name varchar(50) , grade double);
CREATE TABLE statistics(id int , min double , max double , avg double);
INSERT INTO user VALUES (1 , "mohammad" , "mar2001");


