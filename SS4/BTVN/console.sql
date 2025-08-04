create database category_db;
use category_db;

create table Category
(
    id          int primary key auto_increment,
    cate_name   varchar(100),
    description varchar(100),
    status      bit default 1
);

DELIMITER &&
create procedure display_category()
begin
    select * from Category;
end &&
DELIMITER &&

DELIMITER &&
create procedure add_category(
    cate_name_in varchar(100),
    description_in varchar(100),
    status_in bit
)
begin
    insert into Category(cate_name, description, status)
    values (cate_name_in,
            description_in,
            status_in);
end &&
DELIMITER &&

DELIMITER &&
create procedure find_by_id(
    id_in int
)
begin
    select *
    from Category
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure update_category(
    id_in int,
    cate_name_in int,
    description_in varchar(100),
    status_in bit
)
begin
    update Category
    set cate_name   = cate_name_in,
        description = description_in,
        status      = status_in
    where id = id_in;
end &&

create procedure delete_category(
    id_in int
)
begin
    delete
    from Category
    where id = id_in;
end &&
DELIMITER &&
