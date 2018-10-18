--SQL Database to hold the tables for Ticketopia Project. 
--This table will eventually be integrated into a more dynamic table using Hibernate. 

--DDL Section
DROP TABLE CustomerInformation CASCADE CONSTRAINTS;
DROP TABLE Credentials CASCADE CONSTRAINTS;
DROP TABLE PaymentInfo CASCADE CONSTRAINTS;
DROP TABLE UserType CASCADE CONSTRAINTS;
DROP TABLE EventTypes CASCADE CONSTRAINTS;
DROP TABLE Tickets CASCADE CONSTRAINTS;
DROP TABLE Comments CASCADE CONSTRAINTS;
DROP TABLE FreeTickets CASCADE CONSTRAINTS;
DROP TABLE Forum CASCADE CONSTRAINTS;
DROP TABLE Topic CASCADE CONSTRAINTS;
DROP TABLE Posts CASCADE CONSTRAINTS;
DROP TABLE Comments CASCADE CONSTRAINTS;


CREATE TABLE CustomerInformation( 
 userId Number(6), -- pk
 displayName VARCHAR2(100),
 userFName VARCHAR2(100),
 userLName VARCHAR2(100),
 accumulatedPoints NUMBER(8),
 userType NUMBER(6), --This is replacing role since ROLE is a keyword in SQL, fk points to usertype table
 customerAddress VARCHAR2(100),
 customerEmail VARCHAR2 (100),
 CONSTRAINT CustomerInformation_pk PRIMARY KEY (userId)
 );
 
 CREATE TABLE Credentials (
 userId NUMBER (6), --fk points to customerinfo userid
 userPass VARCHAR2(100),
 CONSTRAINT Credentials_fk FOREIGN KEY (userId)
 REFERENCES CustomerInformation (userId)
 );
 
 CREATE TABLE PaymentInfo (
 userId NUMBER(6), --fk points to customerinfo userid
 cardNumber NUMBER (16), --unique
 securityNumber NUMBER(3),
 expirationDate DATE, --Phil is Unsure if this is right. 
 billingAddress VARCHAR2(100),
 billingCity VARCHAR2 (50),
 billingState VARCHAR2 (2),
 billingZip NUMBER (5),
 CONSTRAINT PaymentInfo_fk FOREIGN KEY (userId)
 REFERENCES CustomerInformation (userId) -- [Phil] Not sure if this is what we want this FK to Ref
 );
 
 CREATE TABLE UserType (
roleId NUMBER (6), 
roleName VARCHAR2(100),

CONSTRAINT role_Id_pk PRIMARY KEY (roleId)

 );
 
CREATE TABLE EventTypes(
eventTypeId NUMBER (6), --pk
eventType VARCHAR2 (100),
CONSTRAINT EventTypes_pk PRIMARY KEY (eventTypeId)
);
 
 CREATE TABLE Tickets (
 ticketId NUMBER(6), --pk
 ticketType VARCHAR2 (100),
 topic NUMBER (10), --fk points to topics table
 eventTypeId NUMBER(6), --fk points to eventtypes
 ticketPrice NUMBER (8,2),
 eventDescription VARCHAR2(1000),
 eventAddress VARCHAR2 (100),
 eventCity VARCHAR2 (50),
 eventState VARCHAR2 (2),
 eventZip NUMBER (5),
 seat VARCHAR2(6),
 partnerId NUMBER (6),
 CONSTRAINT Tickets_pk PRIMARY KEY (ticketId),
 CONSTRAINT topic_fk FOREIGN KEY (topic)
    REFERENCES Topics (topicId), --[Phil] Not 100% sure if this is setup correctly.
 CONSTRAINT eventTypeId_fk FOREIGN KEY (eventTypeId)
    REFERENCES EventTypes (eventTypeId) --[Phil] This will need to be looked at too.
 );
 

CREATE TABLE Comments (
topic VARCHAR2 (100), --fk points to topics table
userId NUMBER (6), --fk points to users table
message VARCHAR2(100), 
commentTimeStamp NUMBER(6),
CONSTRAINT Comments_fk FOREIGN KEY (topic)
    REFERENCES Topics (topicId),
CONSTRAINT userId_fk FOREIGN KEY (userId)
    REFERENCES CustomerInformation (userId)
);

CREATE TABLE FreeTickets (
ticketId NUMBER (6), --fk points to tickets table
CONSTRAINT FreeTickets_fk FOREIGN KEY (ticketId)
    REFERENCES Tickets (ticketId)
);

CREATE TABLE Forum (
userId NUMBER(6),
message VARCHAR2(4000),
postId NUMBER (10)
);

CREATE TABLE Topics(
topicId NUMBER (10),
topicName VARCHAR2 (100)
);

CREATE TABLE Posts (
postId NUMBER (10),
postTitle VARCHAR2(50),
postContent VARCHAR2 (500),
topicId NUMBER (10), --fk
userId NUMBER(6),
post TIMESTAMP
);

CREATE TABLE Comments (
commentId NUMBER (10),
commentContent VARCHAR2 (1000),
postId NUMBER (10),
userId NUMBER (6),
post TIMESTAMP
);

CREATE TABLE Partners (
partnerId NUMBER (6),
partnerName VARCHAR2(100)
);

--PL SQL Section Below 

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

CREATE SEQUENCE Credentials_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER Credentials_auto_inc
BEFORE INSERT ON Credentials
FOR EACH ROW
BEGIN
    IF :new.userId IS NULL THEN
        SELECT Credentials_seq.NEXTVAL INTO :new.userId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE PaymentInfo_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER PaymentInfo_auto_inc
BEFORE INSERT ON PaymentInfo
FOR EACH ROW
BEGIN
    IF :new.userId IS NULL THEN
        SELECT PaymentInfo_seq.NEXTVAL INTO :new.userId FROM Dual;
    END IF;
END;
/

CREATE SEQUENCE UserType_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER UserType_auto_inc
BEFORE INSERT ON UserType
FOR EACH ROW
BEGIN
    IF :new.roleId IS NULL THEN
        SELECT UserType_seq.NEXTVAL INTO :new.roleId FROM Dual;
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

CREATE SEQUENCE FreeTickets_seq
    START WITH 0
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER FreeTickets_auto_inc
BEFORE INSERT ON FreeTickets
FOR EACH ROW
BEGIN
    IF :new.ticketId IS NULL THEN
        SELECT FreeTickets_seq.NEXTVAL INTO :new.ticketId FROM Dual;
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