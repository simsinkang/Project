Drop TABLE IF EXISTS users;
CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(15) NOT NULL,
email VARCHAR(30) UNIQUE NOT NULL,
PASSWORD VARCHAR(50) NOT NULL,
phone VARCHAR(50) NOT NULL,
city VARCHAR(110) NOT NULL
)DEFAULT CHARSET=utf8;
insert into users(user_name,email,password,phone,city) values ('changha kim','dd@c','1234','010-7679-4338','광주광역시');
commit;