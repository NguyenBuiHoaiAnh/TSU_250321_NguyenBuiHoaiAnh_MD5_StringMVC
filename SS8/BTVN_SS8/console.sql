create database btvn_ss8;
use btvn_ss8;

create table Student
(
    id    int primary key auto_increment,
    name  varchar(100),
    email varchar(100),
    dob   date
);

-- -------- Student -----------------

-- Display

DELIMITER &&
create procedure display_student()
begin
    select * from Student;
end &&
DELIMITER &&

-- Add

DELIMITER &&
create procedure add_student(
    name_in varchar(100),
    email_in varchar(100),
    dob_in date
)
insert into Student(name, email, dob)
values (name_in,
        email_in,
        dob_in);
DELIMITER &&

-- Update
DELIMITER &&
create procedure find_student_by_id(
    id_in int
)
begin
    select *
    from Student
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure update_student(
    id_in int,
    name_in varchar(100),
    email_in varchar(100),
    dob_in date
)
begin
    update Student
    set name  = name_in,
        email = email_in,
        dob   = dob_in
    where id = id_in;
end &&
DELIMITER &&

-- Delete

DELIMITER &&
create procedure delete_student(
    id_in int
)
begin
    delete
    from Student
    where id = id_in;
end &&
DELIMITER &&