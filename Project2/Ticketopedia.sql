--SQL Database to hold the tables for Ticketopia Project. 
--This table will eventually be integrated into a more dynamic table using Hibernate. 

CREATE TABLE CustomerInformation( --Users cannot be a table name 
 userId Number(6), -- pk
 displayName VARCHAR2(100),
 userFName VARCHAR2(100),
 userLName VARCHAR2(100),
 accumulatedPoints NUMBER(6),
 userType NUMBER(6), --This is replacing role since ROLE is a keyword in SQL, fk points to usertype table
 customerAddress VARCHAR2(100),
 customerEmail VARCHAR2 (100)
 );
 
 CREATE TABLE Credentials (
 userId NUMBER (6), --fk points to customerinfo userid
 userPass VARCHAR2(100)
 );
 
 CREATE TABLE PaymentInfo (
 userId NUMBER(6), --fk points to customerinfo userid
 cardNumber NUMBER (6), --unique
 securityNumber NUMBER(6),
 expirationDate NUMBER(6),
 billingAddress VARCHAR2(100)
 );
 
 CREATE TABLE UserType (
roleId NUMBER (6), 
roleName VARCHAR2(100),

CONSTRAINT role_Id_pk PRIMARY KEY (roleId)


 );
 
 CREATE TABLE Tickets (
 ticketId NUMBER(6), --pk
 ticketType VARCHAR2 (100),
 topic VARCHAR2(100), --fk points to topics table
 eventTypeId NUMBER(6), --fk points to eventtypes
 ticketPrice NUMBER (6),
 eventDescription VARCHAR2(100),
 eventLocation VARCHAR2(100),
 seat NUMBER(6)
 );
 
CREATE TABLE EventTypes(
eventTypeId NUMBER (6), --pk
eventType VARCHAR2 (100)
);

CREATE TABLE Comments (
topic VARCHAR2 (100), --fk points to topics table
userId NUMBER (6), --fk points to users table
message VARCHAR2(100), --Message replaces content since content is a keyword in SQL
commentTimeStamp NUMBER(6)
);

CREATE TABLE Free (
ticketId NUMBER (6) --fk points to tickets table
);

--table topics
--column topicid pk
--column topicname
commit;