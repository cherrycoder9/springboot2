# 정의어

# 1. 게시물 카테고리
drop table if exists bcategory;
create table  bcategory(
                           bcno int unsigned auto_increment ,
                           bcname varchar( 30 ) not null unique,
                           bcdate datetime default now() not null  ,
                           constraint bcategory_bcno_pk primary key ( bcno )
);
insert into bcategory( bcname ) values ( '자유' ) , ( '노하우' ) , ( '판매' ) , ( '구매') ;
select * from bcategory;

# 2. 게시물
drop table if exists board;
create table board(
                      bno bigint unsigned auto_increment ,
                      btitle varchar( 255 ) not null ,
                      bcontent longtext ,
                      bfile longtext ,
                      bview int unsigned default 0 not null ,
                      bdate datetime  default now() not null  ,
                      no  bigint ,
                      bcno int unsigned,
                      constraint board_bno_pk primary key( bno ) ,
                      constraint board_no_fk foreign key( no) references member( no ) on update cascade on delete cascade ,
                      constraint board_bcno_fk foreign key( bcno ) references bcategory( bcno ) on update cascade on delete cascade
);
select *from board;

