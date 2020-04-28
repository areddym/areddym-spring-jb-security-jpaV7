DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT   PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  roles VARCHAR(250) DEFAULT NULL,
  active INT DEFAULT NULL
);
insert into users(id,userName,password,roles,active) values(1,'foo','pass','ROLE_USER',1);
insert into users(id,userName,password,roles,active) values(2,'anand','pass','ROLE_USER,ROLE_ADMIN',1);




