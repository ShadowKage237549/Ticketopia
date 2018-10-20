--SQL Database to hold the tables for Ticketopia Project. 
--This table will eventually be integrated into a more dynamic table using Hibernate. 

--DDL Section
DROP TABLE customer_information CASCADE CONSTRAINTS;
DROP TABLE payment_info CASCADE CONSTRAINTS;
DROP TABLE user_type CASCADE CONSTRAINTS;
DROP TABLE event_types CASCADE CONSTRAINTS;
DROP TABLE tickets CASCADE CONSTRAINTS;
DROP TABLE free_tickets CASCADE CONSTRAINTS;
DROP TABLE topics CASCADE CONSTRAINTS;
DROP TABLE posts CASCADE CONSTRAINTS;
DROP TABLE comments CASCADE CONSTRAINTS;
DROP TABLE partners CASCADE CONSTRAINTS;

CREATE TABLE user_type (
role_id NUMBER (6), --pk
role_name VARCHAR2(100),
CONSTRAINT role_id_pk PRIMARY KEY (role_id)
 );
 
 CREATE TABLE topics(
topic_id NUMBER (10), --pk
topic_name VARCHAR2 (100),
CONSTRAINT topic_pk PRIMARY KEY (topic_id)
);

CREATE TABLE partners (
partner_id NUMBER (6), --pk
partner_name VARCHAR2(100),
CONSTRAINT partner_pk PRIMARY KEY (partner_id)
);
 
CREATE TABLE customer_information( 
 customer_email VARCHAR2 (100), --pk
 display_name VARCHAR2(100) UNIQUE, 
 user_fname VARCHAR2(100),
 user_lname VARCHAR2(100),
 accumulated_points NUMBER(8),
 user_type NUMBER(6), --fk
 customer_address VARCHAR2(100),
 customer_city VARCHAR2(100),
 customer_state VARCHAR2(2),
 customer_zip NUMBER(10),
 customer_password VARCHAR2(50),
 CONSTRAINT CustomerInformation_pk PRIMARY KEY (customer_email),
 CONSTRAINT customer_role_fk FOREIGN KEY (user_type) REFERENCES user_type (role_id)
 );
 
 CREATE TABLE event_types(
event_type_id NUMBER (6), --pk
event_type VARCHAR2 (100),
CONSTRAINT event_types_pk PRIMARY KEY (event_type_id)
);
 
 CREATE TABLE payment_info (
 customer_email VARCHAR2(100), --fk 
 card_number NUMBER (16), 
 security_number NUMBER(3),
 expiration_date DATE, --needs formatting either here or in java. 
 billing_address VARCHAR2(100),
 billing_city VARCHAR2 (50),
 billing_state VARCHAR2 (2),
 billing_zip NUMBER (5),
 CONSTRAINT payment_email_fk FOREIGN KEY (customer_email) REFERENCES customer_information (customer_email)
 );
 

 CREATE TABLE posts (
post_id NUMBER (10), --pk
post_title VARCHAR2(50),
post_content VARCHAR2 (500),
topic_id NUMBER (10), --fk
display_name VARCHAR2(20), --fk
post_timestamp TIMESTAMP,
CONSTRAINT post_pk PRIMARY KEY (post_id),
CONSTRAINT post_topic_fk FOREIGN KEY (topic_id) REFERENCES topics (topic_id),
CONSTRAINT post_user_fk FOREIGN KEY (display_name) REFERENCES customer_information (display_name)
);

 CREATE TABLE tickets (
 ticket_id NUMBER(6), --pk
 ticket_type VARCHAR2 (100),
 topic_id NUMBER (10), --fk points to topics table
 event_type_id NUMBER(6), --fk points to eventtypes
 ticket_price NUMBER (8,2),
 event_description VARCHAR2(1000),
 event_address VARCHAR2 (100),
 event_city VARCHAR2 (50),
 event_state VARCHAR2 (2),
 event_zip NUMBER (5),
 seat VARCHAR2(6),
 partner_id NUMBER (6), --fk
 CONSTRAINT Tickets_pk PRIMARY KEY (ticket_id),
 CONSTRAINT ticket_topic_fk FOREIGN KEY (topic_id) REFERENCES Topics (topic_id), 
 CONSTRAINT ticket_event_type_fk FOREIGN KEY (event_type_id) REFERENCES event_types (event_type_id) 
 );
 

CREATE TABLE comments (
comment_id NUMBER (10), --pk
post_id NUMBER (10), --fk
display_name VARCHAR2(20), --fk points to users table
comment_content VARCHAR2 (1000),
comment_time_stamp TIMESTAMP,
CONSTRAINT comments_pk PRIMARY KEY (comment_id),
CONSTRAINT comment_post_fk FOREIGN KEY (post_id) REFERENCES posts (post_id),
CONSTRAINT userId_fk FOREIGN KEY (display_name) REFERENCES customer_information (display_name)
);

CREATE TABLE free_tickets (
ticket_id NUMBER(6) UNIQUE, --fk points to tickets table
CONSTRAINT free_tickets_fk FOREIGN KEY (ticket_id) REFERENCES tickets (ticket_id)
);





--PL SQL Section Below 
--Add drop sequences prior to creating sequences 

CREATE SEQUENCE CustomerInformation_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER CustomerInformation_auto_inc
BEFORE INSERT ON CustomerInformation
FOR EACH ROW
BEGIN
    IF :new.userId IS NULL THEN
        SELECT CustomerInformation_seq.NEXTVAL INTO :new.userId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE EventTypes_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER EventTypes_auto_inc
BEFORE INSERT ON EventTypes
FOR EACH ROW
BEGIN
    IF :new.eventTypeId IS NULL THEN
        SELECT EventTypes_seq.NEXTVAL INTO :new.eventTypeId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE Tickets_seq
    START WITH 0
    INCREMENT BY 1;
/
    
CREATE OR REPLACE TRIGGER Tickets_auto_inc
BEFORE INSERT ON Tickets
FOR EACH ROW
BEGIN
    IF :new.ticketId IS NULL THEN
        SELECT Tickets_seq.NEXTVAL INTO :new.ticketId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE Comments_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER Comments_auto_inc
BEFORE INSERT ON Comments
FOR EACH ROW
BEGIN
    IF :new.userId IS NULL THEN
        SELECT Comments_seq.NEXTVAL INTO :new.userId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE Forum_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER Forum_auto_inc
BEFORE INSERT ON Forum
FOR EACH ROW
BEGIN
    IF :new.userId IS NULL THEN
        SELECT Forum_seq.NEXTVAL INTO :new.userId FROM Dual;
    END IF;
END;
/





commit;