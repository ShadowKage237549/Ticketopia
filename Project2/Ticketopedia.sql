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
'regression films ltd',
'regression films aims to sell discounted tickets by directly working with movie producers.'

);

INSERT INTO partners VALUES (
2,
'smokey music ltd',
'smokey music ltd, has been working with various bands and private musicians to provide discount tickets.'
);

--Create a Customer information table
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

--Create 10 basic, 10 premium, and 4 admin accounts. Premiums have points, basic does not, admin can have anything. 

--Premium users first because they should be top priority for having subscriptions. 
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

--Basic users - those who use our service but do not pay us money. 
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


--admin users AKA the Developers. 

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

--Createa  table for the event types that are held. 
CREATE TABLE event_types (
	event_type_id NUMBER(6),
     --pk
	event_type VARCHAR2(100),
	CONSTRAINT event_types_pk PRIMARY KEY ( event_type_id )
);

--Insert information into the DB for event types
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
1,
'Movie Ticket',
1,
99,
'Movie',
'777 Zmax Blvd',
'Reston',
'Virginia',
869434,
'Z-1',
1,
0
);

INSERT INTO tickets VALUES (
2,
'Movie Ticket',
1,
700,
'Movie',
'921 HungerGames Lane',
'Topeka',
'Kansas',
654657,
'A-1',
1,
0
);

INSERT INTO tickets VALUES (
3,
'Concert Ticket',
2,
1000,
'Concert',
'1800 North University Drive',
'Fargo',
'North Dakota',
581052,
'A-1',
2,
0
);

INSERT INTO tickets VALUES (
4,
'Concert Ticket',
2,
350,
'Concert',
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
1,
'Venom the Movie!',
'Venom'
);

INSERT INTO topics VALUES (
2,
2,
'Avengers: Infinity War Pt 2 the movie',
'Avengers: Infinity War 2'
);

INSERT INTO topics VALUES (
3,
3,
'Disturbed live at Fargo Dome',
'Thoughts on Disturbed live'
);

INSERT INTO topics VALUES (
4,
4,
'Eminem live in Detroit Michigan',
'Discussion on Eminem concert history'
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
'Venom was Over hyped.',
1
);

INSERT INTO posts_title VALUES (
3,
'INFINITY WAR 2 HYPE @#!@$@!$!@',
2
);

INSERT INTO posts_title VALUES (
4,
'How should I dress for an Eminem Concert?',
2
);

INSERT INTO posts_title VALUES (
5,
'Venom was over hyped',
3
);

INSERT INTO posts_title VALUES (
6,
'Avengers: Infinity War 2... will anyone who died previously return?',
3
);

INSERT INTO posts_title VALUES (
7,
'That Disturbed concert was a bust... they are getting old and should retire',
4
);

INSERT INTO posts_title VALUES (
8,
'Eminem - King or God of Rap?',
4
);

CREATE TABLE posts (
	post_id NUMBER(10),  --pk
	post_title_id NUMBER(6),--fk
	customer_email VARCHAR2(100),--fk
	post_content VARCHAR2(500),
	post_timestamp TIMESTAMP,
	CONSTRAINT post_pk PRIMARY KEY ( post_id ),
	CONSTRAINT post_topic_fk FOREIGN KEY ( post_title_id )
		REFERENCES posts_title ( post_title_id ),
	CONSTRAINT post_user_fk FOREIGN KEY ( customer_email )
		REFERENCES customer_information ( customer_email )
);

INSERT INTO posts VALUES (
1,
1,
'destiny.a@gmail.com',
'Venom was amazing! The way he transformed... his style, he is my FAVORITE VILLAIN!!! AHHH',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
2,
1,
'johndoe@.yahoo.com',
'Keeping things real, Venom is so much more fascinating than Spiderman. He looks better, and is overall just better.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
3,
2,
'gbriggs@briggs.com',
'I am so excited for Infinity War Pt 2. I have watched all of the Avengers movies and recently started watching all of the Marvel movies from start to finish. I LOVE CAPTAIN AMERICA!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
4,
2,
'srussel@russel.com',
'Infinity War was one of the best movies I have seen. I do not know if it can be trumped so I am remaining optimistic for Part 2 of it. #THOR',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
5,
3,
'zprososki@prososki.net',
'That conert was lit... for real!!!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
6,
3,
'cstrife@strifeforce.com',
'Disturbed... the gods of metal. Do not @ me.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
7,
4,
'zprososki@prososki.net',
'Would I be okay wearing a hoodie that is too big for me to kind of mimic Eminem? I do not want someone thinking I am doing something unpleasant.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
8,
4,
'birdothegreat@bln.com',
'Who wants to dress up like THE REAL SLIM SHADY with me and my crew tonight?!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
9,
5,
'tdawgy09@hotmail.com',
'Went to Venom. Kept an open mind. Ended up walking out halfway through it. Except for the CGI in the Movie, it did not meet my tatses.',
SYSTIMESTAMP    
);

INSERT INTO posts VALUES (
10,
5,
'gbriggs@outlook.com',
'Well I went to see Venom. I sat through the entire movie and mostly enjoyed it however, I would have preferred a deeper story for him. Felt a bit weak.',
SYSTIMESTAMP    
);

INSERT INTO posts VALUES (
11,
6,
'hamurai@hotmail.com',
'IS it true that Spiderman died in Infinity war?? WILL HE BE BACK?!?!?!',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
12,
6,
'rprososki@prososki.net',
'Starlord, forreal?!',
SYSTIMESTAMP    
);

INSERT INTO posts VALUES (
13,
7,
'gmiller@aol.com',
'I was so disappointed with Disturbed in person. David Draimen is losing his screamo voice.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
14,
7,
'cbroadwell@admin.net',
'I am a huge fan of Disturbed but I truly feel like it is time they hang up their hats. They are legends in their own right but, the new music I have heard just is not what they are or who they were.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
15,
8,
'bslappey@admin.net',
'I do not like Rap. I do not know why I am even commenting on this forum about Eminem. I am very bored. It is 2:00 in the morning. Goodnight World.',
SYSTIMESTAMP
);

INSERT INTO posts VALUES (
16,
8,
'twilson@gmail.com',
'If you do not think Slim Shady / Eminem / B Rabbit / Marshall Mathers is the one true Rap God, you can get out the kitchen. YOU ARE WHACKED YO! XD XD XD XD XD XD',
SYSTIMESTAMP
);

COMMIT;
