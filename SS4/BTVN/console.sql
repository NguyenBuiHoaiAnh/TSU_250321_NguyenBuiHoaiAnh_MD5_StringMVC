create database category_db;
use category_db;

create table Category
(
    id          int primary key auto_increment,
    cate_name   varchar(100),
    description varchar(100),
    status      bit default 1
);

create table Product
(
    id          int primary key auto_increment,
    name        varchar(100),
    description varchar(255),
    category_id int,
    constraint fk_p_category_id
    foreign key (category_id)
        references Category (id)
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
    declare count_product_id int default 0;

    select count(*)
    into count_product_id
    from Product
    where category_id = id_in;

    if count_product_id = 0 then
        delete
        from Category
        where id = id_in;
    else
        update Category
        set status = 0
        where id = id_in;
    end if;
end &&
DELIMITER &&
