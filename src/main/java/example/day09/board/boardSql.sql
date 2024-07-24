drop database if exists Board;
create database Board;

use Board;

create table wholepage
(
    pno     int auto_increment,
    ptitle  varchar(20),
    pdate   datetime default now(),
    pview   int      default 0,
    pdetail longtext,
    ppwd    int not null,
    primary key (pno)
);
#read
select *
from wholepage;
# 샘플(create)
insert wholepage(ptitle, pdetail, ppwd)
values ("안녕하세요1", "반갑습니다1", "1234");
insert wholepage(ptitle, pdetail, ppwd)
values ("안녕하세요2", "반갑습니다2", "12345");
insert wholepage(ptitle, pdetail, ppwd)
values ("안녕하세요3", "반갑습니다3", "12346");
insert wholepage(ptitle, pdetail, ppwd)
values ("안녕하세요4", "반갑습니다4", "12367");
insert wholepage(ptitle, pdetail, ppwd)
values ("안녕하세요5", "반갑습니다5", "12378");

# 샘플(update)
update wholepage
set ptitle  = "안녕하세요!",
    pdetail = "반가워요1"
where ppwd = "1234"
  and pno = 1;

# 샘플(delete)
delete
from wholepage
where pno = 1
  and ppwd = "1234";