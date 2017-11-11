DROP TABLE user_detail;

DROP TABLE user_user_role;

DROP TABLE user_role;

CREATE TABLE user_detail (
    user_id      NUMBER,
    username     VARCHAR(20) NOT NULL,
    firstname    VARCHAR(20),
    middlename   VARCHAR(20),
    lastname     VARCHAR(20),
    email        VARCHAR(20),
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
    CONSTRAINT pk_od PRIMARY KEY ( user_role_id )
);

    CREATE TABLE USER_USER_ROLE (
    user_id INT,
    user_role_id INT,
    CONSTRAINT fk_f_f1 FOREIGN KEY ( user_id ) REFERENCES user_detail(user_id),
    CONSTRAINT fk_f_f2 FOREIGN KEY ( user_role_id ) REFERENCES user_role(user_role_id)
    );

<-------------------------------------------------------------------------------------------------------------------------------------------->

INSERT INTO user_detail VALUES (
    2,
    '283mayank@gmail.com',
    'Maya',
    NULL,
    'Bansal',
    '283mayank@gmail.com',
    'true',
    'Bhoolgaye@10'
);

COMMIT;

SELECT
    *
FROM
    user_detail;
    
update user_detail set password = 'ddcf5e599ffa22db3ef522ade5c5c02b' where user_id = 22;
    
DESC user_detail;

ALTER TABLE user_detail modify password VARCHAR(50);

ALTER TABLE user_detail DROP CONSTRAINT pk_p_p1;

ALTER TABLE user_detail DROP COLUMN role_id;

DELETE user_detail;
<-------------------------------------------------------------------------------------------------------------------------------------------->

INSERT INTO user_role VALUES (
    2,
    'Role_User',
    sysdate,
    sysdate
);

COMMIT;

SELECT
    *
FROM
    user_role;
    
DELETE user_role;

<-------------------------------------------------------------------------------------------------------------------------------------------->

SELECT * FROM USER_USER_ROLE;

DELETE user_user_role;

<-------------------------------------------------------------------------------------------------------------------------------------------->

CREATE TABLE employee (
    emp_id     INT,
    emp_name   VARCHAR(20),
    CONSTRAINT pk_p_p2 PRIMARY KEY ( emp_id )
);

SELECT
    *
FROM
    employee;
<-------------------------------------------------------------------------------------------------------------------------------------------->

CREATE TABLE PASSWORD (
    pass_id   NUMBER,
    pass_value  VARCHAR(20),
    emp_id NUMBER,
    CONSTRAINT pk_p_password PRIMARY KEY ( pass_id ),
    CONSTRAINT fk_passemp FOREIGN KEY ( emp_id ) REFERENCES employee ( emp_id ) 
);

INSERT INTO PASSWORD VALUES (3,'Kfnfndjf@85jf',3);

COMMIT;

SELECT * FROM PASSWORD;

SELECT EMP.EMP_NAME,PASS.PASS_VALUE FROM EMPLOYEE EMP JOIN PASSWORD PASS ON EMP.EMP_ID=PASS.EMP_ID;

SELECT EMP.EMP_NAME,PASS.PASS_VALUE FROM EMPLOYEE EMP, PASSWORD PASS WHERE EMP.EMP_ID=PASS.EMP_ID;

DROP Table password;

<-------------------------------------------------------------------------------------------------------------------------------------------->
SELECT
    ud.*,
    auth.role_name
FROM
    user_detail ud
    JOIN user_authorities ua ON ud.user_id = ua.user_id
    JOIN authorities auth ON  ua.role_id =auth.role_id
WHERE
    ud.username =:username;
<-------------------------------------------------------------------------------------------------------------------------------------------->
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


DROP SEQUENCE role_sq;

/**Query for user_roles_vo*/  
  SELECT
    ur.user_rolename
FROM
    user_detail u
    JOIN USER_USER_ROLE uur ON u.user_id = uur.user_id
    JOIN user_role ur ON ur.user_role_id = uur.user_role_id where u.username = :username;