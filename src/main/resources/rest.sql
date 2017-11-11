CREATE TABLE user_detail (
    user_id      NUMBER,
    username     VARCHAR(20) NOT NULL,
    firstname    VARCHAR(20),
    middlename   VARCHAR(20),
    lastname     VARCHAR(20),
    email        VARCHAR(20),
    password     VARCHAR(50),
    enable       VARCHAR(6),
    created_date    DATE,
    modified_date   DATE,
    CONSTRAINT pk_ud PRIMARY KEY ( user_id )
);

    CREATE TABLE user_role (
    user_role_id    NUMBER,
    user_rolename   VARCHAR(20),
    created_date    DATE,
    modified_date   DATE,
    CONSTRAINT pk_rd PRIMARY KEY ( user_role_id )
);

    CREATE TABLE USER_USER_ROLE (
    user_id INT,
    user_role_id INT,
    CONSTRAINT fk_f_f1 FOREIGN KEY ( user_id ) REFERENCES user_detail(user_id),
    CONSTRAINT fk_f_f2 FOREIGN KEY ( user_role_id ) REFERENCES user_role(user_role_id)
    );


CREATE SEQUENCE user_detail_sq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  CREATE SEQUENCE role_sq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;


DROP TABLE user_detail;

DROP TABLE user_user_role;

DROP TABLE user_role;

DROP SEQUENCE role_sq;