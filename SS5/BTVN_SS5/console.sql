create database bt1_ss5_springmvc;
use bt1_ss5_springmvc;

create table Customer
(
    id       int primary key auto_increment,
    username varchar(100) unique not null,
    password VARCHAR(100)        not null,
    phone    varchar(10),
    address  varchar(255),
    gender   varchar(10),
    email    varchar(100),
    role     enum ('ADMIN','USER') default 'USER'
);

create table Movie
(
    id          int auto_increment primary key,
    title       varchar(255) not null unique,
    director    varchar(70),
    genre       varchar(50),
    description varchar(255),
    duration    int,
    language    varchar(30)
);

create table ScreenRoom
(
    id               int primary key auto_increment,
    screen_room_name varchar(100) not null unique,
    totalSeat        int check (totalSeat > 0)
);

create table Schedule
(
    id              int primary key auto_increment,
    movie_title     varchar(100),
    movie_id        int,
    show_time       timestamp,
    screen_room_id  int,
    available_seats int,
    format          varchar(10),
    foreign key (movie_id)
        references Movie (id),
    foreign key (screen_room_id)
        references ScreenRoom (id)
);

create table Ticket
(
    id         Integer auto_increment primary key,
    customerId int,
    scheduleId int,
    seatName   varchar(20),
    totalMoney double,
    created_at date,
    foreign key (customerId)
        references Customer (id),
    foreign key (scheduleId)
        references Schedule (id)
);

-- --------------------------------------------------

-- Login

DELIMITER &&
create procedure login(
    username_in varchar(100),
    password_in varchar(100)
)
begin
    select username, password, role
    from Customer
    where username = username_in
      and password = password_in;
end &&
DELIMITER &&

-- ------------------- Movies ------------------------

-- Display
DELIMITER &&
create procedure display_movies()
begin
    select * from Movie;
end &&
DELIMITER &&

-- Create
DELIMITER &&
create procedure add_movies(
    title_in varchar(255),
    director_in varchar(70),
    genre_in varchar(50),
    description_in varchar(255),
    duration_in int,
    language_in varchar(30)
)
begin
    insert into Movie(title, director, genre, description, duration, language)
    values (title_in,
            director_in,
            genre_in,
            description_in,
            duration_in,
            language_in);
end &&
DELIMITER &&

-- Update
DELIMITER &&
create procedure find_by_id(
    id_in int
)
begin
    select *
    from Movie
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure update_movie(
    id_in int,
    title_in varchar(255),
    director_in varchar(70),
    genre_in varchar(50),
    description_in varchar(255),
    duration_in int,
    language_in varchar(30)
)
begin
    update Movie
    set title       = title_in,
        director    = director_in,
        genre       = genre_in,
        description = description_in,
        duration    = duration_in,
        language    = language_in
    where id = id_in;
end &&
DELIMITER &&

-- Delete
DELIMITER &&
create procedure delete_movie(
    id_in int
)
begin
    delete
    from Movie
    where id = id_in;
end &&
DELIMITER &&

-- ------------------- Schedule --------------------

-- Display
DELIMITER &&
create procedure display_schedule_screenroom()
begin
    select s.*, sr.screen_room_name
    from Schedule s
             inner join ScreenRoom sr
                        on s.screen_room_id = sr.id;
end &&
DELIMITER &&

-- Create
DELIMITER &&
create procedure get_screenroom()
begin
    select * from Screenroom;
end &&
DELIMITER &&

DELIMITER &&
create procedure add_schedule(
    movie_title_in varchar(100),
    movie_id_in int,
    show_time_in date,
    screen_room_id_in int,
    available_seats_in int,
    format_in varchar(10)
)
begin
    insert into Schedule (movie_title, movie_id, show_time,
                          screen_room_id, available_seats, format)
    values (movie_title_in, movie_id_in,
            show_time_in, screen_room_id_in,
            available_seats_in, format_in);
end
&&
DELIMITER &&

-- Update
DELIMITER &&
create procedure find_schedule_by_id(
    id_in int
)
begin
    select *
    from Schedule
    where id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure update_schedule(
    id_in int,
    movie_title_in varchar(255),
    movie_id_in varchar(70),
    show_time_in varchar(50),
    screen_room_id_in varchar(255),
    available_seats_in int,
    format_in varchar(30)
)
begin
    update Schedule
    set movie_title     = movie_title_in,
        movie_id        = movie_id_in,
        show_time       = show_time_in,
        screen_room_id  = screen_room_id_in,
        available_seats = available_seats_in,
        format          = format_in
    where id = id_in;
end &&
DELIMITER &&

-- Delete
DELIMITER &&
create procedure delete_movie(
    id_in int
)
begin
    delete
    from Movie
    where id = id_in;
end &&
DELIMITER &&