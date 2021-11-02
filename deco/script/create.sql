create table cafe(
   idx int auto_increment,
   name varchar(25) not null,
   content varchar(100) not null,
   phone varchar(20) not null,
   addr varchar(50) not null,
   menu varchar(200) not null,
   opentime varchar(10) not null,
   closetime varchar(10) not null,
   grade decimal(3,2) not null,
   location varchar(10) not null,
   outimage varchar(100),   -- list에 들어갈 image
   inimage varchar(100),   -- detail에 들어갈 image
   primary key(idx)
);

create table users(
   idx int auto_increment,
   name varchar(5) not null,
   password varchar(10) not null,
   email varchar(30) not null,
   gender char(15) check (gender in ('남','여')),
   age tinyint not null,
   phone varchar(11) not null,
   addr varchar(50) not null,
   nickname varchar(10) not null,
   primary key(idx)
);

create table shows(
   sidx int auto_increment,
   name varchar(25) not null,
   content varchar(100) not null,
   phone varchar(20) not null,
   addr varchar(50) not null,
   menu varchar(200) not null,
   opentime varchar(10) not null,
   closetime varchar(10) not null,
   grade decimal(3,2) not null,
   location varchar(10) not null,
   outimage varchar(100),   -- list에 들어갈 image
   inimage varchar(100),   -- detail에 들어갈 image
   link varchar(100),
   primary key(sidx)
);

create table etc(
   eidx int auto_increment,
   name varchar(25) not null,
   content varchar(100) not null,
   phone varchar(20) not null,
   addr varchar(50) not null,
   menu varchar(200) not null,
   opentime varchar(10) not null,
   closetime varchar(10) not null,
   grade decimal(3,2) not null,
   location varchar(10) not null,
   outimage varchar(100),   -- list에 들어갈 image
   inimage varchar(100),   -- detail에 들어갈 image
   primary key(eidx)
);

create table food(
   fidx int auto_increment,
   name varchar(25) not null,
   content varchar(200) not null,
   phone varchar(20) not null,
   addr varchar(50) not null,
   menu varchar(200) not null,
   opentime varchar(10) not null,
   closetime varchar(10) not null,
   grade decimal(3,2) not null,
   location varchar(10) not null,
   outimage varchar(100),  
   inimage varchar(100),   
   primary key(fidx)
);

create table dibs(
   idx int auto_increment primary key,
   dibCafe varchar(300),
   dibFood varchar(300),
   dibShow varchar(300),
   dibEx varchar(300),
   nickname varchar(10) not null,
   foreign key (nickname) references users(nickname)
);

select * from users;


create table review(
   idx int auto_increment,   -- 번호
   nickname varchar(30) not null, -- 리뷰 작성 시 email
   grade int not null, -- 리뷰 평점
   content varchar(500) not null, -- 리뷰 내용
   category varchar(20) not null,
   imgfile varchar(100),
   refidx int,
   fidx int,
   sidx int,
   eidx int,
   primary key(idx),
   foreign key(nickname) references users(nickname),
   foreign key(refidx) references cafe(idx),
   foreign key(fidx) references food(fidx),
   foreign key(sidx) references shows(sidx),
   foreign key(eidx) references etc(eidx)
);