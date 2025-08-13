create database springmvc_ss10;
use springmvc_ss10;

create table customer
(
    id           int auto_increment primary key,
    full_name    varchar(100),
    phone_number varchar(20)               not null unique,
    email        varchar(100)              not null unique,
    password     varchar(255)              not null,
    address      varchar(255)              not null,
    role         enum ('ADMIN','CUSTOMER') not null default 'CUSTOMER'
);

create table rooms
(
    id        int primary key auto_increment,
    room_name varchar(100),
    room_type varchar(100),
    status    enum ('PLACED','EMPTY') default 'EMPTY',
    is_delete bit          not null   default 0,
    price     double,
    image     varchar(255)
);

create table booking
(
    id           int auto_increment primary key,
    customer_id  int not null,
    room_id      int not null,
    booking_date date   not null,
    price        double not null,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp on update current_timestamp,
    foreign key (customer_id) references customer (id),
    foreign key (room_id) references rooms (id)
);

-- --------------------------------------------------------------------------

-- Register
DELIMITER &&
create procedure register_customer(
    full_name_in varchar(100),
    phone_number_in varchar(20),
    email_in varchar(100),
    password_in varchar(255),
    address_in varchar(255)
)
begin
    insert into customer (full_name, phone_number, email, password, address)
    values (full_name_in,
            phone_number_in,
            email_in,
            password_in,
            address_in);
end &&
DELIMITER &&

-- Login
DELIMITER &&
create procedure customer_login(
    email_in varchar(100),
    password_in varchar(255)
)
begin
    select *
    from customer
    where email = email_in
      and password = password_in;
end &&
DELIMITER &&

-- -------------------------------------------------------------------

-- Customer List
DELIMITER &&
create procedure get_all_customer()
begin
    select * from customer;
end &&
DELIMITER &&

-- --------------------------------------------------------------------

-- Rooms

DELIMITER &&

-- CRUD
create procedure add_room(
    in p_room_name varchar(255),
    in p_room_type varchar(50),
    in p_status enum ('PLACED', 'EMPTY'),
    in p_price double,
    in p_image varchar(255)
)
begin
    insert into rooms(room_name, room_type, status, price, image)
    values (p_room_name, p_room_type, p_status, p_price, p_image);
end&&

create procedure get_room_by_id(in p_id bigint)
begin
    select *
    from rooms
    where id = p_id
      and is_delete = 0;
end&&

create procedure update_room(
    in p_id int,
    in p_room_name varchar(255),
    in p_room_type varchar(50),
    in p_status enum ('PLACED', 'EMPTY'),
    in p_price double,
    in p_image varchar(255)
)
begin
    update rooms
    set room_name = p_room_name,
        room_type = p_room_type,
        status    = p_status,
        price     = p_price,
        image     = p_image
    where id = p_id
      and is_delete = false;
end&&

create procedure delete_room(
    in p_id int
)
begin
    update rooms
    set is_delete = true
    where id = p_id;
end&&

create procedure update_room_status(
    in p_id int,
    in p_status enum ('PLACED', 'EMPTY')
)
begin
    update rooms
    set status = p_status
    where id = p_id
      and is_delete = false;
end&&

create procedure get_rooms(
    in p_limit int,
    in p_page int,
    out p_total_pages int
)
begin
    declare v_total_records int;
    declare v_offset int;

    select count(*)
    into v_total_records
    from rooms
    where is_delete = false;

    set p_total_pages = ceil(v_total_records / p_limit);
    set v_offset = (p_page - 1) * p_limit;

    select *
    from rooms
    where is_delete = false
    limit p_limit offset v_offset;
end&&

-- ------------------------------------------------

create procedure is_room_name_unique(
    in p_id int,
    in p_room_name varchar(255)
)
begin
    select count(*) as cnt
    from rooms
    where room_name = p_room_name
      and (p_id is null or id <> p_id)
      and is_delete = false;
end&&

DELIMITER &&;

-- -----------------------------------------------------

DELIMITER &&

create procedure add_booking(
    in p_customer_id int,
    in p_room_id int,
    in p_booking_date date,
    in p_price double
)
begin
    insert into booking (customer_id, room_id, booking_date, price)
    values (p_customer_id,
            p_room_id,
            p_booking_date,
            p_price);
end &&


-- đếm số lượng khách hàng
create procedure count_customers(out total_customers int)
begin
    select count(*) into total_customers from customer;
end &&

-- doanh thu theo tháng hiện tại
create procedure get_revenue_current_month(out revenue double)
begin
    select sum(price)
    into revenue
    from booking
    where month(booking_date) = month(curdate())
      and year(booking_date) = year(curdate());
end &&

-- top 3 phòng được đặt nhiều nhất
create procedure get_top3_rooms()
begin
    select r.id, r.room_name, count(b.id) as booking_count
    from rooms r
             join booking b on r.id = b.room_id
    group by r.id, r.room_name
    order by booking_count desc
    limit 3;
end &&

-- top 5 khách hàng đặt phòng nhiều nhất
create procedure get_top5_customers()
begin
    select c.id, c.full_name, count(b.id) as booking_count
    from customer c
             join booking b on c.id = b.customer_id
    group by c.id, c.full_name
    order by booking_count desc
    limit 5;
end &&

DELIMITER ;