DROP SEQUENCE employee_seq;
CREATE SEQUENCE employee_seq START WITH 1 INCREMENT BY 1;
DROP TABLE employee;
CREATE TABLE employee (
    id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50) NOT NULL,
    last_name VARCHAR2(50) NOT NULL,
    dni VARCHAR2(50) UNIQUE NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    phone_number VARCHAR2(15),
    hire_date DATE,
    salary NUMBER(8, 2)
);