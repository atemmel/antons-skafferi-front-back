/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fredriksellgren
 * Created: 2 dec. 2019
 */

DELETE FROM ItemOrder;
DELETE FROM Item;
DELETE FROM ItemCategory;
DELETE FROM Customer;
DELETE FROM Dinnertable;
DELETE FROM todayslunch;
DELETE FROM EmployeeSchedule;
DELETE FROM Employee;
DELETE FROM workingschedule;
DELETE FROM User;


insert into todayslunch (mealname, days, type)
VALUES ('Lax och spenatsoppa',1,'Fisk'),
('Stek',1,'Kötträtt'),
('Spagetti bolognaise',2,'Pasta'),
('Örtbakad torskfilé med gratinerad potatismos',2,'Fisk'),
('Köttfärsås och Spagetti',2,'Kött'),
('Fish and chips med remouladsås',3,'Fisk'),
('Stekt fläsk med löksås',3,'För köttälskare'),
('Pastagratäng',3,'Pasta'),
('Fish and chips',4,'Fisk'),
('Stekt fläsk',4,'För köttälskare'),
('Pasta med rökt kassler purjolök och cocktailtomater',4,'Pasta'),
('Fiskchips med remouladsås',5,'Fisk');

insert into ItemCategory (itemcategoryid, name, url)
VALUES (1,'Kockens val','url'),
(2,'Förrätt','url'),
(3,'Huvudrätt','url'),
(4,'Effterätt','url'),
(5,'Dryck','url');

insert into ITEM (itemid, title, price, description, itemcategoryid)
VALUES (1,'Bakad fläskkarre',115,'gräddstuvad kål, senapssky, äppelmos, rostad morot',3),
(2,'Oxbringa',115,'senapssås, pepparrot, rostad potatis, bakad lök, persilja',3),
(3,'Fiskgryta',115,'sej, musslor, potatis, fänkål, dill, citron, aioli',3),
(4,'Tomatsoppa',115,'Ägg 63, chili, krutonger, basilika',2),
(5,'Cola',115,'33CL',5),
(6,'Skakentoast',115,'Toast med skagenröra',2),
(7,'Renskav',115,'Renskav med potatis',1),
(8,'Glass',115,'3 skopor vaniljglass med colasås',4),
(9,'Vildssvin',115,'Vildssvinskotlett med potatisgratäng',1),
(10,'Spagetti med kötfärsås',115,'Serveras med parmesanost',3);

insert into Dinnertable (dinnertableid, description, sizesoftable, active)
VALUES (1,'Fonsterbord',4,false),
(2,'Salong',4,false),
(3,'Fonsterbord',4,false),
(4,'Mitten',6,false),
(5,'Salong',4,false),
(6,'Ingång',4,false),
(7,'Mitten',6,false);


insert into Customer(customerid, firstname, lastname, sizeofcompany, email, bookingtime, bookingdate, phone)
VALUES (1, 'Allan', 'Takkolander', 4, 'Test@email.com','21:30','2019-02-02', '070-3123431');  

insert into ItemOrder(orderid, amount, note, ready, dinnertableid, itemid)
VALUES (1,1,'Utan Ost',1,1,1),
(2,1,'Med Ost',0,2,1);

insert into User (username, password, administrator)
VALUES ('Anton', '123', true),
('Takko','hej',false);

insert into Employee (employeeid, fname, lname, username)
VALUES(1,'Anton','Antonsson','Anton'),
(2,'William','Takolander','Takko');

insert into WORKINGSCHEDULE (workingscheduleid, date, end, start)
VALUES(1,'2019-01-01','23:30','14:00'),
(2,'2019-01-01','20:00','08:00'),
(3,'2019-01-01','18:00','12:00'),
(4,'2019-01-01','16:00','08:00');

insert into EMPLOYEESCHEDULE (employeescheduleid, employeeid, workingscheduleid)
VALUES(1,1,1),
(2,2,2),
(3,1,3),
(4,2,4);
