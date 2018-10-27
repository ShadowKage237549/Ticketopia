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
DROP TABLE topics CASCADE CONSTRAINTS;
DROP TABLE posts_title CASCADE CONSTRAINTS;


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
'smokey music ltd',
'smokey music ltd, has been working with various bands and private musicians to provide discount tickets.'
);

INSERT INTO partners VALUES (
2,
'regression films ltd',
'regression films aims to sell discounted tickets by directly working with movie producers.'
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
'bob.bobson@mafia.net',
'Mafia Master',
'Bob',
'Bobson',
98765432,
2,
'100 Killer Rd',
'Heart Broken Town',
'MN',
999969,
'password'
);

INSERT INTO customer_information VALUES (
'johndoe@.yahoo.com',
'JDoe',
'John',
'Doe',
10000,
2,
'111 Cloud Ln',
'St. Cloud',
'Mn',
553519,
'DJDoe'
);

INSERT INTO customer_information VALUES (
'hamurai@hotmail.com',
'Hamurai',
'Ham',
'Urai',
4000,
2,
'111 Ham Way',
'Hampton',
'Ohio',
403281,
'swords'
);

INSERT INTO customer_information VALUES (
'destiny.a@gmail.com',
'TheDestiny',
'Destiny',
'Adams',
7500,
2,
'2342 Destined Rd',
'Mankato',
'Kentucky',
666656,
'Starbucks'
);

INSERT INTO customer_information VALUES (
'twilson@gmail.com',
'TheWilsonator',
'Todd',
'Wilson',
100,
2,
'9675307 Fairie Rd',
'Bullhead Citay',
'Arizona',
532496,
'ChevyMan1234'
);

INSERT INTO customer_information VALUES (
'gmiller@aol.com',
'Glenninator',
'Glenn',
'Miller',
9876,
2,
'555 Miller Way',
'Millerton',
'California',
999799,
'ILoveMiller'
);

INSERT INTO customer_information VALUES (
'tdawgy09@hotmail.com',
'Travalanche',
'Travis',
'Eid',
98216,
2,
'703 W Prairie Rd',
'Palmerville',
'Minnesota',
553120,
'Vinnymyboy'
);

INSERT INTO customer_information VALUES (
'birdothegreat@bln.com',
'Birdo',
'Brandon',
'Eid',
7777,
2,
'21407 Hilltop Cres',
'The Grove',
124095,
2,
'CapitalOneRocks'
);

INSERT INTO customer_information VALUES (
'rprososki@prososki.net',
'PrososkiR',
'Rachel',
'Prososki',
8888,
2,
'4321 Sunfish Rd',
'Maple Grove',
'AK',
987265,
'admin5547'
);

INSERT INTO customer_information VALUES (
'gbriggs@briggs.com',
'CatchinGretchen',
'Gretchen',
'Briggs',
500,
2,
'328 Ferry St',
'Pinnacle Lakes',
'WI',
173584,
'HanselandGrettle'
);
--Basic users
INSERT INTO customer_information VALUES (
'srussel@russel.com',
'Mr.Russell',
'Shane',
'Russel',
0,
1,
'17 Shady Way',
'Isolation Island',
'Hawaii',
444244,
'Hexadecimal'
);

INSERT INTO customer_information VALUES (
'clane@lanes.net',
'ExpertRacer',
'Carmani',
'Lane',
0,
1,
'1800 Racer Valley',
'Tampa Bay',
'Florida',
986642,
'Porsche'
);

INSERT INTO customer_information VALUES (
'gbriggs@outlook.com',
'General Briggs',
'Greg',
'Briggs',
0,
1,
'42342 Brigadier Lane',
'The Bay',
'MA',
097507,
'Gophers'
); 

INSERT INTO customer_information VALUES (
'cstrife@strifeforce.com',
'Ex-SOLDIER',
'Cloud',
'Strife',
0,
1,
'465748 7th Ave',
'Middleton',
'New Jersey',
987965,
'BusterSword'
);

INSERT INTO customer_information VALUES (
'ottm@otttech.net',
'Kane',
'Michael',
'Ott',
0,
1,
'100 Presidential Ave',
'Capital Hill',
'D.C.',
623416,
'TheUndertaker'
);

INSERT INTO customer_information VALUES (
'jjohnson@aol.com',
'JjBoombox',
'Jordan',
'Johnson',
0,
1,
'1857 Chidori Cir',
'Wyoming',
'Kentucky',
107410,
'ILikeTurtles'
);

INSERT INTO customer_information VALUES (
'msowl@owly.com',
'OliviatheOwl',
'Olivia',
'Owllette',
0,
1,
'6415 Joker blvd',
'San Antonio',
'Texas',
760143,
'OwlsAreSoCute!'
);

INSERT INTO customer_information VALUES (
'srenity@yahoo.com',
'Ms.Renity',
'Serenity',
'Smith',
0,
1,
'7654 Elm St',
'Portland',
'Oregon',
687429,
'SereneSkies'
);

INSERT INTO customer_information VALUES (
'zprososki@prososki.net',
'PrincessZ',
'Zariah',
'Prososki',
0,
1,
'101 1st St',
'Holland',
'Minnesota',
568055,
'Vaporeon'
);


--admin below

INSERT INTO customer_information VALUES (
'cbroadwell@admin.net',
'Cory Broadwell',
'Cory',
'Broadwell',
56789053,
3,
'111 Anime Street',
'The Great Tomb of Nazarick',
'Yggdrasil',
777877,
'admin1'
);

INSERT INTO customer_information VALUES (
'cgomez@admin.net',
'Courie Gomez',
'Courie',
'Gomez',
34567,
3,
'123 19th Ave',
'That one City We Do Not Name',
'Nothingness',
867253,
'admin2'
);

INSERT INTO customer_information VALUES (
'bslappey@admin.net',
'Ben Slappey',
'Ben',
'Slappey',
4567890,
3,
'555 Slappin ln',
'Slapsville',
'Slapinia',
88888,
'admin3'
);

INSERT INTO customer_information VALUES(
'pprososki@admin.net',
'Philip Prososki',
'Phil',
'Prososki',
9876543,
3,
'651 Soul Reaper Ln',
'Soul Society',
'Otherside',
212812,
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
	expiration_date VARCHAR2(45),
     --needs formatting either here or in java. 
	billing_address VARCHAR2(100),
	billing_city VARCHAR2(50),
	billing_state VARCHAR2(20),
	billing_zip NUMBER(6),
	CONSTRAINT payment_email_fk FOREIGN KEY ( customer_email )
		REFERENCES customer_information ( customer_email )
);

INSERT INTO payment_info VALUES (
'bob.bobson@mafia.net',
1000555577777888,
000,
01/99,
'111 Killer Rd',
'Heart Broken Town',
'Mn',
543876
);

--Have 5 shots of rum and start making up CC numbers 

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
	event_zip NUMBER(6),
	seat VARCHAR2(600),
	partner_id NUMBER(6),
     --fk
	free_flag NUMBER(1),
	CONSTRAINT tickets_pk PRIMARY KEY ( ticket_id ),
	CONSTRAINT ticket_event_type_fk FOREIGN KEY ( event_type_id )
		REFERENCES event_types ( event_type_id )
);

INSERT INTO tickets VALUES (
7,
'Movie Ticket',
1,
99,
'Back Row seating for Venom with beer, popcorn, and ices included',
'777 Zmax Blvd',
'Reston',
'Virginia',
869434,
'Z-1',
1,
0
);

INSERT INTO tickets VALUES (
9,
'Movie Ticket',
1,
700,
'Hunger games 5 with Jennifer Lawrence as your date',
'921 HungerGames Lane',
'Topeka',
'Kansas',
654657,
'A-1',
1,
0
);

INSERT INTO tickets VALUES (
5,
'Concert Ticket',
2,
1000,
'Meet and Greet with dinner included with Members of Disturbed',
'1800 North University Drive',
'Fargo',
'North Dakota',
581052,
'A-1',
2,
0
);

INSERT INTO tickets VALUES (
8,
'Concert Ticket',
2,
350,
'Back stage passes to Eminem',
'888 Grover Street',
'Los Angelos',
'Rhode Island',
987987,
'Side of Live Stage',
2,
0
);

CREATE TABLE topics(
	topic_id NUMBER(6),
	ticket_id NUMBER(6),
	topic_name VARCHAR2(100),
	topic_desc VARCHAR2(200), --Description on the ticket
	CONSTRAINT topics_pk PRIMARY KEY (topic_id),
	CONSTRAINT topic_ticket_fk FOREIGN KEY ( ticket_id )
		REFERENCES tickets ( ticket_id )
);
INSERT INTO topics VALUES (
1,
7,
'Venom the Movie!',
'Ticket admitting entrance to the movie Venom'
);

INSERT INTO topics VALUES (
2,
9,
'Avengers: Infinity War Pt 2',
'Ticket for one person to watching Avengers: Infinity War 2'
);

INSERT INTO topics VALUES (
3,
5,
'Disturbed live at Fargo Dome',
'Back stage passes to meet Disturbed the band.'
);

INSERT INTO topics VALUES (
4,
8,
'Eminem live in Detroit Michigan',
'Meet and Greet with the Rap God himiself: Marshall Mathers'
);


CREATE TABLE posts_title (
	post_title_id NUMBER(6),
	post_title VARCHAR2(100),
	topic_id NUMBER(6),
	CONSTRAINT post_title_pk PRIMARY KEY ( post_title_id ),
	CONSTRAINT post_title_fk FOREIGN KEY ( topic_id )
		REFERENCES topics ( topic_id )
);

INSERT INTO posts_title VALUES (
1,
'DID YOU SEE HOW VENOM TRANSFORMED?!!!@#',
1
);

INSERT INTO posts_title VALUES (
2,
'INFINITY WAR PT 2 HYPEEEEEE!$!@$!$@!$@!$@',
2
);

INSERT INTO posts_title VALUES (
3,
'The fire shooting out from the stage during the concert... made me almost pass out!',
3
);

INSERT INTO posts_title VALUES (
4,
'How should I dress for an Eminem Concert?',
2
);


CREATE TABLE posts (
	post_id NUMBER(10),  --pk
	ticket_id NUMBER(6),--fk
	display_name VARCHAR2(20),--fk
	post_content VARCHAR2(500),
	post_timestamp TIMESTAMP,
	CONSTRAINT post_pk PRIMARY KEY ( post_id ),
	CONSTRAINT post_topic_fk FOREIGN KEY ( ticket_id )
		REFERENCES tickets ( ticket_id ),
	CONSTRAINT post_user_fk FOREIGN KEY ( display_name )
		REFERENCES customer_information ( display_name )
);

INSERT INTO posts VALUES (
1,
7,
'TheDestiny',
'Venom was amazing! The way he transformed... his style, he is my FAVORITE VILLAIN!!! AHHH',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
2,
9,
'JDoe',
'I am beyond stoked for the next part of Infinity war! I LOVE MARVEL!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
3,
5,
'CatchinGretchen',
'I got caught up in the moshpit during the Disturbed concert... I got knocked out and they had to stop the concert because of me... as an apology I got to meet the Band! It was so fun!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
4,
8,
'Mr.Russell',
'I got to see Eminem in concert, Im such a fan of rap and his style. It was fantastic to see the master of the dictionary in person!',
SYSTIMESTAMP
);

COMMIT;
