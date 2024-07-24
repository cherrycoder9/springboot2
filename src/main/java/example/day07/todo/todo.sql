DROP
    DATABASE IF EXISTS todo;
CREATE
    DATABASE todo;
USE
    todo;
CREATE TABLE todo
(
    id        int         NOT NULL AUTO_INCREMENT,
    todo      varchar(30) NOT NULL,
    completed tinyint(1)  NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

INSERT INTO todo
    (todo, completed)
VALUES ('todo1', 0),
       ('todo2', 0),
       ('todo3', 0),
       ('todo4', 0),
       ('todo5', 0),
       ('todo6', 0),
       ('todo7', 0),
       ('todo8', 0),
       ('todo9', 0),
       ('todo10', 0);

DELETE
FROM todo;

TRUNCATE TABLE todo;

DELETE
FROM todo
WHERE completed = 0;

SELECT *
FROM todo
ORDER BY completed;

SELECT *
FROM todo;