DROP SCHEMA IF EXISTS biotrio;
create schema biotrio collate utf8mb4_0900_ai_ci;
USE biotrio;
DROP PROCEDURE IF EXISTS PROC_DROP_FOREIGN_KEY;
DELIMITER $$
CREATE PROCEDURE PROC_DROP_FOREIGN_KEY(IN tableName VARCHAR(64), IN constraintName VARCHAR(64))
BEGIN
    IF EXISTS(
        SELECT * FROM information_schema.table_constraints
        WHERE
            table_schema    = DATABASE()     AND
            table_name      = tableName      AND
            constraint_name = constraintName AND
            constraint_type = 'FOREIGN KEY')
    THEN
        SET @query = CONCAT('ALTER TABLE ', tableName, ' DROP FOREIGN KEY ', constraintName, ';');
        PREPARE stmt FROM @query;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END IF;
END$$
DELIMITER;
CALL PROC_DROP_FOREIGN_KEY('orders', 'FKp23lx8o6n71bl0y4klavavbea');
CALL PROC_DROP_FOREIGN_KEY('orders', 'FKa3oma4scer0t5ibdbt0a3o39');
CALL PROC_DROP_FOREIGN_KEY('screen_halls', 'FKd4m8b3vy1r35fkk17ei4fvjux');
CALL PROC_DROP_FOREIGN_KEY('screenings', 'FKo68mjpfuam0iure0akiummtoc');
CALL PROC_DROP_FOREIGN_KEY('screenings', 'FK554lnni8xq5mue4b0qk2elnra');
CALL PROC_DROP_FOREIGN_KEY('seats', 'FKj6kpvaro1g2voggp627rhf9jp');
CALL PROC_DROP_FOREIGN_KEY('tickets', 'FKpo24ki6ifwtk5wfm5faglm54s');
CALL PROC_DROP_FOREIGN_KEY('tickets', 'FK1h45fc0qums718psyh07lhykn');
CALL PROC_DROP_FOREIGN_KEY('tickets', 'FKiucvp29cqnjj8kpeljpkr6646');
CALL PROC_DROP_FOREIGN_KEY('user_role', 'FKa68196081fvovjhkek5m97n3y');
CALL PROC_DROP_FOREIGN_KEY('user_role', 'FKl4qqtaxj0v5ikodha3v2pmfl');
drop table if exists carousel_item
drop table if exists cinemas
drop table if exists movie
drop table if exists orders
drop table if exists order_status
drop table if exists role
drop table if exists screen_halls
drop table if exists screenings
drop table if exists seats
drop table if exists tickets
drop table if exists user_role
drop table if exists users
create table carousel_item
(
	carousel_itemid int auto_increment
		primary key,
	image varchar(255) null,
	text varchar(255) null,
	title varchar(255) null
);

create table cinemas
(
	cinemaid int auto_increment
		primary key,
	address varchar(255) null,
	description varchar(255) null,
	name varchar(255) null
);

create table movie
(
	movieid int auto_increment
		primary key,
	age_rating varchar(255) null,
	description longtext null,
	genre varchar(255) null,
	image varchar(255) null,
	length int not null,
	name varchar(255) null,
	video varchar(255) null
);

create table order_status
(
	order_statusid int auto_increment
		primary key,
	name varchar(255) null,
	seat_taken bit not null,
	usable bit not null
);

create table role
(
	role_id int auto_increment
		primary key,
	role varchar(255) null
);

create table screen_halls
(
	screen_hallid int auto_increment
		primary key,
	name varchar(255) null,
	cinemaid int null,
	constraint FKd4m8b3vy1r35fkk17ei4fvjux
		foreign key (cinemaid) references cinemas (cinemaid)
);

create table screenings
(
	screeningid int auto_increment
		primary key,
	cleaning int not null,
	cost int not null,
	start_time datetime null,
	movieid int null,
	screen_hallid int null,
	constraint FK554lnni8xq5mue4b0qk2elnra
		foreign key (screen_hallid) references screen_halls (screen_hallid),
	constraint FKo68mjpfuam0iure0akiummtoc
		foreign key (movieid) references movie (movieid)
);

create table seats
(
	seatid int auto_increment
		primary key,
	seat_name varchar(255) null,
	x varchar(255) null,
	y varchar(255) null,
	screen_hallid int null,
	constraint FKj6kpvaro1g2voggp627rhf9jp
		foreign key (screen_hallid) references screen_halls (screen_hallid)
);

create table users
(
	userid int auto_increment
		primary key,
	active int not null,
	address varchar(255) null,
	email varchar(255) null,
	first_name varchar(255) null,
	last_name varchar(255) null,
	password varchar(255) null,
	phone varchar(255) null
);

create table orders
(
	order_number int auto_increment
		primary key,
	customerid int null,
	order_statusid int null,
	constraint FKa3oma4scer0t5ibdbt0a3o39
		foreign key (order_statusid) references order_status (order_statusid),
	constraint FKp23lx8o6n71bl0y4klavavbea
		foreign key (customerid) references users (userid)
);

create table tickets
(
	ticketid int auto_increment
		primary key,
	cost int not null,
	used bit not null,
	order_number int null,
	screeningid int null,
	seatid int null,
	constraint FK1h45fc0qums718psyh07lhykn
		foreign key (screeningid) references screenings (screeningid),
	constraint FKiucvp29cqnjj8kpeljpkr6646
		foreign key (seatid) references seats (seatid),
	constraint FKpo24ki6ifwtk5wfm5faglm54s
		foreign key (order_number) references orders (order_number)
);

create table user_role
(
	userid int not null,
	role_id int not null,
	primary key (userid, role_id),
	constraint FKa68196081fvovjhkek5m97n3y
		foreign key (role_id) references role (role_id),
	constraint FKl4qqtaxj0v5ikodha3v2pmfl
		foreign key (userid) references users (userid)
);

