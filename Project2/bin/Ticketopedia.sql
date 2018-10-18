--SQL Database to hold the tables for Ticketopia Project. 
--This table will eventually be integrated into a more dynamic table using Hibernate. 

--DDL Section
DROP TABLE CustomerInformation;
DROP TABLE Credentials;
DROP TABLE PaymentInfo;
DROP TABLE UserType;
DROP TABLE EventTypes;
DROP TABLE Tickets;
DROP TABLE Comments;
DROP TABLE FreeTickets;
DROP TABLE Forum;


CREATE TABLE CustomerInformation( 
 userId Number(6), -- pk
 displayName VARCHAR2(100),
 userFName VARCHAR2(100),
 userLName VARCHAR2(100),
 accumulatedPoints NUMBER(8,2),
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
 topic VARCHAR2(100), --fk points to topics table
 eventTypeId NUMBER(6), --fk points to eventtypes
 ticketPrice NUMBER (8,2),
 eventDescription VARCHAR2(1000),
 eventAddress VARCHAR2 (100),
 eventCity VARCHAR2 (50),
 eventState VARCHAR2 (2),
 eventZip NUMBER (5),
 seat NUMBER(6),
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
message VARCHAR2(4000)
);

CREATE TABLE Topics(
topicId NUMBER (100),
topicName VARCHAR2 (100)
);
--PL SQL Section Below 
commit;