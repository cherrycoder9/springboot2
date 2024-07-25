-- 데이터베이스를 삭제하고 새로 생성
DROP DATABASE IF EXISTS springweb;
CREATE DATABASE springweb;
USE springweb;

-- 회원 테이블 삭제 및 생성
DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    no    BIGINT AUTO_INCREMENT,       -- 회원번호, 자동 증가
    id    VARCHAR(30) NOT NULL UNIQUE, -- 회원 아이디, 고유한 값
    pw    VARCHAR(30) NOT NULL,        -- 회원 비밀번호
    name  VARCHAR(20) NOT NULL,        -- 회원 이름
    email VARCHAR(50),                 -- 회원 이메일
    phone VARCHAR(13) NOT NULL UNIQUE, -- 회원 핸드폰 번호, 고유한 값
    PRIMARY KEY (no)                   -- 기본 키 설정
);

-- 회원 샘플 데이터 삽입
INSERT INTO member (id, pw, name, email, phone)
VALUES ('user1', '1234', '홍길동', 'hong@example.com', '010-1234-5678'),
       ('user2', '1234', '이순신', 'lee@example.com', '010-2345-6789'),
       ('user3', '1234', '박영희', 'park@example.com', '010-3456-7890'),
       ('user4', '1234', '김철수', 'kim@example.com', '010-4567-8901'),
       ('user5', '1234', '최영', 'choi@example.com', '010-5678-9012'),
       ('user6', '1234', '안중근', 'ahn@example.com', '010-6789-0123'),
       ('user7', '1234', '유관순', 'yu@example.com', '010-7890-1234'),
       ('user8', '1234', '정약용', 'jeong@example.com', '010-8901-2345'),
       ('user9', '1234', '장보고', 'jang@example.com', '010-9012-3456'),
       ('user10', '1234', '신사임당', 'shin@example.com', '010-0123-4567');


-- 게시물 카테고리 테이블 삭제 및 생성
DROP TABLE IF EXISTS bcategory;
CREATE TABLE bcategory
(
    bcno   INT UNSIGNED AUTO_INCREMENT,            -- 카테고리 번호, 자동 증가
    bcname VARCHAR(30)            NOT NULL UNIQUE, -- 카테고리 이름, 고유한 값
    bcdate DATETIME DEFAULT NOW() NOT NULL,        -- 카테고리 생성 날짜
    PRIMARY KEY (bcno)                             -- 기본 키 설정
);

-- 게시물 카테고리 샘플 데이터 삽입
INSERT INTO bcategory (bcname)
VALUES ('자유'),   -- 자유 카테고리
       ('노하우'),  -- 노하우 카테고리
       ('판매'),   -- 판매 카테고리
       ('구매'),   -- 구매 카테고리
       ('공지사항'), -- 공지사항 카테고리
       ('질문답변'), -- 질문답변 카테고리
       ('구직'),   -- 구직 카테고리
       ('구인');
-- 구인 카테고리


-- 게시물 테이블 삭제 및 생성
DROP TABLE IF EXISTS board;
CREATE TABLE board
(
    bno      BIGINT UNSIGNED AUTO_INCREMENT,                                           -- 게시물 번호, 자동 증가
    btitle   VARCHAR(255)               NOT NULL,                                      -- 게시물 제목
    bcontent LONGTEXT,                                                                 -- 게시물 내용
    bfile    LONGTEXT,                                                                 -- 첨부 파일 (파일 경로 또는 파일명)
    bview    INT UNSIGNED DEFAULT 0     NOT NULL,                                      -- 조회수, 기본값 0
    bdate    DATETIME     DEFAULT NOW() NOT NULL,                                      -- 게시물 작성 날짜
    no       BIGINT,                                                                   -- 회원 번호, 외래 키
    bcno     INT UNSIGNED,                                                             -- 카테고리 번호, 외래 키
    PRIMARY KEY (bno),                                                                 -- 기본 키 설정
    FOREIGN KEY (no) REFERENCES member (no) ON UPDATE CASCADE ON DELETE CASCADE,       -- 회원 외래 키 설정
    FOREIGN KEY (bcno) REFERENCES bcategory (bcno) ON UPDATE CASCADE ON DELETE CASCADE -- 카테고리 외래 키 설정
);

-- 게시물 샘플 데이터 삽입
INSERT INTO board (btitle, bcontent, bview, no, bcno)
VALUES ('첫 번째 게시글', '첫 번째 게시글의 내용입니다.', 10, 1, 1),
       ('두 번째 게시글', '두 번째 게시글의 내용입니다.', 20, 2, 2),
       ('세 번째 게시글', '세 번째 게시글의 내용입니다.', 30, 3, 3),
       ('네 번째 게시글', '네 번째 게시글의 내용입니다.', 40, 4, 4),
       ('다섯 번째 게시글', '다섯 번째 게시글의 내용입니다.', 50, 5, 1),
       ('여섯 번째 게시글', '여섯 번째 게시글의 내용입니다.', 60, 6, 2),
       ('일곱 번째 게시글', '일곱 번째 게시글의 내용입니다.', 70, 7, 3),
       ('여덟 번째 게시글', '여덟 번째 게시글의 내용입니다.', 80, 8, 4),
       ('아홉 번째 게시글', '아홉 번째 게시글의 내용입니다.', 90, 9, 1),
       ('열 번째 게시글', '열 번째 게시글의 내용입니다.', 100, 10, 2);


-- 데이터 확인 쿼리
SELECT *
FROM member; -- 회원 테이블의 모든 데이터
SELECT *
FROM bcategory; -- 게시물 카테고리 테이블의 모든 데이터
SELECT *
FROM board; -- 게시물 테이블의 모든 데이터
