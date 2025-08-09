create database db_category;
use db_category;

create table Category
(
    id            int primary key auto_increment,
    category_name varchar(100) not null unique,
    description   varchar(100) not null,
    status        bit default 1
);

DELIMITER &&
create procedure get_all_categories()
begin
    select * from Category;
end &&
DELIMITER &&

DELIMITER &&
create procedure check_exist_category_name(
    category_name_in int
)
begin
    select *
    from Category
    where category_name = category_name_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure create_category(
    category_name_in varchar(100),
    description_in varchar(100),
    status_in bit
)
begin
    insert into Category(category_name, description, status)
    values (category_name_in,
            description_in,
            status_in);
end&&
DELIMITER &&

DELIMITER &&
create procedure update_category(
    id_in int,
    category_name_in varchar(100),
    description_in varchar(100),
    status_in bit
)
begin
    update Category
    set category_name = category_name_in,
        description   = description_in,
        status        = status_in
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure get_category_by_id(
    id_in int
)
begin
    select *
    from Category
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure delete_category(
    id_in int
)
begin
    delete
    from Category
    where id = id_in;
end &&
DELIMITER &&
