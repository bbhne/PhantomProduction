drop database if exists phantomdb;

create database if not exists phantomdb;
use phantomdb;


drop table if exists user_table;

create table user_table(
	user_number int not null primary key auto_increment,
	account_id nvarchar(30),
	item_transaction_id int,
	user_name nvarchar(30),
	user_pass nvarchar(30),
	user_mail nvarchar(255)
);

	INSERT INTO user_table VALUES(1,"phantom_production",1,"zahura","phantom225","phantompro225@yahoo.co.jp");
	INSERT INTO user_table VALUES(2,"phantom_production2",2,"ザフラ","phantom225","zahura225@yahoo.co.jp");


drop table if exists admin_table;

create table admin_table(
	user_number int not null primary key auto_increment,
	account_id nvarchar(30),
	item_transaction_id int,
	user_name nvarchar(30),
	user_pass nvarchar(30),
	user_mail nvarchar(255)
);

INSERT INTO admin_table VALUES(1,"phantom_production",1,"zahura","phantom225","phantompro225@yahoo.co.jp");
INSERT INTO admin_table VALUES(2,"phantom_production2",2,"ザフラ","phantom225","zahura225@yahoo.co.jp");

drop table if exists item_table;

create table item_table(
	item_number int not null primary key auto_increment,
	item_transaction_id int,
	item_name nvarchar(255),
	item_image varchar(255),
	item_type nvarchar(255),
	item_price int,
	item_stock int
);

	INSERT INTO item_table VALUES(1,null,"OrcinusBlue","./image/orbl.png","book",1000,9);
	INSERT INTO item_table VALUES(2,null,"アドニスブルーの瞳","./image/orbl.png","book",500,6);
	INSERT INTO item_table VALUES(3,null,"ScarletCode","./image/scar2.png","book",1500,12);
	INSERT INTO item_table VALUES(4,null,"MaximumFear","./image/orbl.png","book",1000,2);
	INSERT INTO item_table VALUES(5,null,"Ogre","./image/orbl.png","game",1500,5);
	INSERT INTO item_table VALUES(6,null,"DarkBlue","./image/orbl.png","game",1000,7);
	INSERT INTO item_table VALUES(7,null,"青い影","./image/orbl.png","book",500,3);
	INSERT INTO item_table VALUES(8,null,"SteelRain","./image/orbl.png","game",1000,4);
	INSERT INTO item_table VALUES(9,null,"花喰ヒ鳥_白夜","./image/orbl.png","sound",1000,7);
	INSERT INTO item_table VALUES(10,null,"花喰ヒ鳥_極夜","./image/orbl.png","sound",1000,2);



drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	item_number int not null primary key auto_increment,
	item_transaction_id int,
	account_id nvarchar(30),
	total_price int,
	total_count int,
	pay nvarchar(30)
);

	INSERT INTO user_buy_item_transaction VALUES(1,1,"phantom_production",1500,2,"現金払い");

drop table if exists inquiry_table;

create table inquiry_table(
	name varchar(255),
	qtype varchar(255),
	body varchar(255)
);

drop table if exists search_type_table;

create table search_type_table(
	item_type varchar(255),
	name varchar(255)
);

INSERT INTO search_type_table VALUES(null,"orucinus");