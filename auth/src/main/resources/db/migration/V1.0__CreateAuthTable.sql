CREATE TABLE IF NOT EXISTS USERS(
    uuid varchar(100) NOT NULL,
    name varchar(10) NOT NULL,
    last_name varchar(10) NOT NULL,
    date_created DATE NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(50) NOT NULL,
    PRIMARY KEY (uuid )
    );