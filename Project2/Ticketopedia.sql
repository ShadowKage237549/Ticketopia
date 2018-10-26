--SQL Database to hold the tables for Ticketopia Project. 
--This table will eventually be integrated into a more dynamic table using Hibernate. 

--DDL Section
DROP TABLE customer_information CASCADE CONSTRAINTS;
DROP TABLE payment_info CASCADE CONSTRAINTS;
DROP TABLE user_type CASCADE CONSTRAINTS;
DROP TABLE event_types CASCADE CONSTRAINTS;
DROP TABLE tickets CASCADE CONSTRAINTS;
DROP TABLE posts CASCADE CONSTRAINTS;
DROP TABLE partners CASCADE CONSTRAINTS;
CREATE TABLE user_type (
	role_id NUMBER(6),
     --pk
	role_name VARCHAR2(100),
	CONSTRAINT role_id_pk PRIMARY KEY ( role_id )
);
INSERT INTO user_type VALUES (
	1,
	'basic'
);
INSERT INTO user_type VALUES (
	2,
	'premium'
);
INSERT INTO user_type VALUES (
	3,
	'admin'
);
CREATE TABLE partners (
	partner_id NUMBER(6),
     --pk
	partner_name VARCHAR2(100),
    partner_description VARCHAR2(250),
	CONSTRAINT partner_pk PRIMARY KEY ( partner_id )
);

INSERT INTO partners VALUES (
1,
'Smokey Music Ltd',
'Smokey Music Ltd, has been working with various bands and private musicians to provide discount tickets.'
);

INSERT INTO partners VALUES (
2,
'Regression films Ltd',
'Regression films aims to sell discounted tickets by directly working with movie producers.'
);

CREATE TABLE customer_information (
	customer_email VARCHAR2(100),
     --pk
	display_name VARCHAR2(100) UNIQUE,
	user_fname VARCHAR2(100),
	user_lname VARCHAR2(100),
	accumulated_points NUMBER(8),
	user_type NUMBER(6),
     --fk
	customer_address VARCHAR2(100),
	customer_city VARCHAR2(100),
	customer_state VARCHAR2(20),
	customer_zip NUMBER(10),
	customer_password VARCHAR2(50),
	CONSTRAINT CustomerInformation_pk PRIMARY KEY ( customer_email ),
	CONSTRAINT customer_role_fk FOREIGN KEY ( user_type )
		REFERENCES user_type ( role_id )
);

INSERT INTO customer_information VALUES(
'Bob.Bobson@mafia.net',
'Mafia Master',
'Bob',
'Bobson',
98765432,
2,
'100 Killer Rd',
'Heart Broken Town',
'MN',
99999,
'password'
);

INSERT INTO customer_information VALUES (
'JohnDoe@.yahoo.com',
'JDoe',
'John',
'Doe',
10000,
2,
'111 Cloud Ln',
'St. Cloud',
'Mn',
55319,
'DJDoe'
);

INSERT INTO customer_information VALUES (
'Hamurai@hotmail.com',
'Hamurai',
'Ham',
'Urai',
4000,
2,
'111 Ham Way',
'Hampton',
'Ohio',
40281,
'swords'
);

INSERT INTO customer_information VALUES (
'Destiny.A@gmail.com',
'TheDestiny',
'Destiny',
'Adams',
7500,
2,
'2342 Destined Rd',
'Mankato',
'Kentucky',
66666,
'Starbucks'
);

INSERT INTO customer_information VALUES (
'TWilson@gmail.com',
'TheWilsonator',
'Todd',
'Wilson',
100,
2,
'9675307 Fairie Rd',
'Bullhead Citay',
'Arizona',
53296,
'ChevyMan1234'
);

INSERT INTO customer_information VALUES (
'GMiller@aol.com',
'Glenninator',
'Glenn',
'Miller',
9876,
2,
'555 Miller Way',
'Millerton',
'California',
99999,
'ILoveMiller'
);

INSERT INTO customer_information VALUES (
'TDawgy09@hotmail.com',
'Travalanche',
'Travis',
'Eid',
98216,
2,
'703 W Prairie Rd',
'Palmerville',
'Minnesota',
55320,
'Vinnymyboy'
);

INSERT INTO customer_information VALUES (
'BirdoTheGreat@bln.com',
'Birdo',
'Brandon',
'Eid',
7777,
2,
'21407 Hilltop Cres',
'The Grove',
12409,
2,
'CapitalOneRocks'
);

INSERT INTO customer_information VALUES (
'RPrososki@prososki.net',
'PrososkiR',
'Rachel',
'Prososki',
8888,
2,
'4321 Sunfish Rd',
'Maple Grove',
'AK',
98765,
'admin5547'
);

INSERT INTO customer_information VALUES (
'GBriggs@briggs.com',
'CatchinGretchen',
'Gretchen',
'Briggs',
500,
2,
'328 Ferry St',
'Pinnacle Lakes',
'WI',
17384,
'HanselandGrettle'
);
--Basic users
INSERT INTO customer_information VALUES (
'SRussel@russel.com',
'Mr.Russel',
'Shane',
'Russel',
0,
1,
'17 Shady Way',
'Isolation Island',
'Hawaii',
44444,
'Hexadecimal'
);

INSERT INTO customer_information VALUES (
'CLane@lanes.net',
'ExpertRacer',
'Carmani',
'Lane',
0,
1,
'1800 Racer Valley',
'Tampa Bay',
'Florida',
98642,
'Porsche'
);

INSERT INTO customer_information VALUES (
'GBriggs@outlook.com',
'General Briggs',
'Greg',
'Briggs',
0,
1,
'42342 Brigadier Lane',
'The Bay',
'MA',
09707,
'Gophers'
); 

INSERT INTO customer_information VALUES (
'CStrife@strifeforce.com',
'Ex-SOLDIER',
'Cloud',
'Strife',
0,
1,
'465748 7th Ave',
'Middleton',
'New Jersey',
98765,
'BusterSword'
);

INSERT INTO customer_information VALUES (
'OttM@otttech.net',
'Kane',
'Michael',
'Ott',
0,
1,
'100 Presidential Ave',
'Capital Hill',
'D.C.',
62341,
'TheUndertaker'
);

INSERT INTO customer_information VALUES (
'Jjohnson@aol.com',
'JjBoombox',
'Jordan',
'Johnson',
0,
1,
'1857 Chidori Cir',
'Wyoming',
'Kentucky',
10410,
'ILikeTurtles'
);

INSERT INTO customer_information VALUES (
'MsOwl@owly.com',
'OliviatheOwl',
'Olivia',
'Owllette',
0,
1,
'6415 Joker blvd',
'San Antonio',
'Texas',
76013,
'OwlsAreSoCute!'
);

INSERT INTO customer_information VALUES (
'Srenity@yahoo.com',
'Ms.Renity',
'Serenity',
'Smith',
0,
1,
'7654 Elm St',
'Portland',
'Oregon',
68429,
'SereneSkies'
);

INSERT INTO customer_information VALUES (
'Zprososki@prososki.net',
'PrincessZ',
'Zariah',
'Prososki',
0,
1,
'101 1st St',
'Holland',
'Minnesota',
56055,
'Vaporeon'
);


--admin below

INSERT INTO customer_information VALUES (
'CBroadwell@admin.net',
'Cory Broadwell',
'Cory',
'Broadwell',
56789053,
3,
'111 Anime Street',
'The Great Tomb of Nazarick',
'Yggdrasil',
77777,
'admin1'
);

INSERT INTO customer_information VALUES (
'CGomez@admin.net',
'Courie Gomez',
'Courie',
'Gomez',
34567,
3,
'123 19th Ave',
'That one City We Do Not Name',
'Nothingness',
86753,
'admin2'
);

INSERT INTO customer_information VALUES (
'BSlappey@admin.net',
'Ben Slappey',
'Ben',
'Slappey',
4567890,
3,
'555 Slappin ln',
'Slapsville',
'Slaphio',
88888,
'admin3'
);

INSERT INTO customer_information VALUES(
'PPrososki@admin.net',
'Philip Prososki',
'Phil',
'Prososki',
9876543,
3,
'651 Soul Reaper Ln',
'Soul Society',
'Otherside',
21212,
'admin4'
);


CREATE TABLE event_types (
	event_type_id NUMBER(6),
     --pk
	event_type VARCHAR2(100),
	CONSTRAINT event_types_pk PRIMARY KEY ( event_type_id )
);

INSERT INTO event_types VALUES (
1,
'Venom at Zmax'
);

INSERT INTO event_types VALUES (
2,
'Disturbed in Concert - Fargo Dome'
);


CREATE TABLE payment_info (
	customer_email VARCHAR2(100),
     --fk 
	card_number NUMBER(16),
	security_number NUMBER(3),
	expiration_date DATE,
     --needs formatting either here or in java. 
	billing_address VARCHAR2(100),
	billing_city VARCHAR2(50),
	billing_state VARCHAR2(2),
	billing_zip NUMBER(5),
	CONSTRAINT payment_email_fk FOREIGN KEY ( customer_email )
		REFERENCES customer_information ( customer_email )
);
CREATE TABLE tickets (
	ticket_id NUMBER(6),
     --pk
	ticket_type VARCHAR2(100),
	event_type_id NUMBER(6),
     --fk points to eventtypes
	ticket_price NUMBER(8, 2),
	event_description VARCHAR2(1000),
	event_address VARCHAR2(100),
	event_city VARCHAR2(50),
	event_state VARCHAR2(20),
	event_zip NUMBER(5),
	seat VARCHAR2(6),
	partner_id NUMBER(6),
     --fk
	free_flag NUMBER(1),
	CONSTRAINT Tickets_pk PRIMARY KEY ( ticket_id ),
	CONSTRAINT ticket_event_type_fk FOREIGN KEY ( event_type_id )
		REFERENCES event_types ( event_type_id )
);

INSERT INTO tickets VALUES (
1,
'Movie Ticket',
1,
99,
'Back Row seating for Venom with beer, popcorn, and ices included',
'777 Zmax Blvd',
'Reston',
'Virginia',
86943,
'Z-1',
1,
0
);

INSERT INTO tickets VALUES (
2,
'Concert Ticket',
2,
1000,
'Meet and Greet with dinner included with Members of Disturbed',
'1800 North University Drive',
'Fargo',
'North Dakota',
58102,
'Front-Row',
2,
0
);


CREATE TABLE topics(
	topic_id NUMBER(6),
	ticket_id NUMBER(6),
	topic_name VARCHAR2(100),
	topic_desc VARCHAR2(200),
	CONSTRAINT topics_pk PRIMARY KEY (topic_id),
	CONSTRAINT topic_ticket_fk FOREIGN KEY ( ticket_id )
		REFERENCES tickets ( ticket_id )
);

INSERT INTO topics VALUES (
1,
1,
'Venom the Movie!',
'This movie was great. How the actor transformed into Venom had me all MIND=BLOWN!!!!'
);

INSERT INTO topics VALUES (
2,
2,
'Disturbed. . . Legends possibly?',
'I got to meet David Draimen, nicest guy ever. He even signed my Disturbed Tattoo and wished me well! CANNOT WAIT TO SEE THEM AGAIN!'
);

CREATE TABLE posts_title (
	post_title_id NUMBER(6),
	post_title VARCHAR2(50),
	topic_id NUMBER(6),
	CONSTRAINT post_title_pk PRIMARY KEY ( post_title_id ),
	CONSTRAINT post_title_fk FOREIGN KEY ( topic_id )
		REFERENCES topics ( topic_id )
);
CREATE TABLE posts (
	post_id NUMBER(10),
     --pk
	ticket_id NUMBER(6),
     --fk
	display_name VARCHAR2(20),
     --fk
	post_content VARCHAR2(500),
	post_timestamp TIMESTAMP,
	CONSTRAINT post_pk PRIMARY KEY ( post_id ),
	CONSTRAINT post_topic_fk FOREIGN KEY ( ticket_id )
		REFERENCES tickets ( ticket_id ),
	CONSTRAINT post_user_fk FOREIGN KEY ( display_name )
		REFERENCES customer_information ( display_name )
);
COMMIT;
