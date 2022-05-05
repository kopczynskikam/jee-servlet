CREATE DATABASE newsletter character set utf8mb4 collate utf8mb4_unicode_ci;

use newsletter;

CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE requests (
                          id INT auto_increment not null primary key,
                          userAgent VARCHAR(255),
                          queryDateTime VARCHAR(255),
                          queryTime VARCHAR(255)
);

drop table requestsParams;

create table requestsParams (
                                id INT NOT NULL PRIMARY KEY auto_increment,
                                request_id INT NOT NULL,
                                paramName VARCHAR(255),
                                paramValue VARCHAR(255),
                                foreign key (request_id) references requests(id)
);

show tables;
select * from requestsParams;
Delete from requestsParams where id=15
select * from requests;