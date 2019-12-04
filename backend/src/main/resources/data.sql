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

insert into todayslunch (mealname, days, type)
VALUES ('Lax och spenatsoppa',1,'Fisk'),
('Stek',1,'Kötträtt'),
('Spagetti bolognaise',2,'Pasta'),
('Örtbakad torskfilé med gratinerad potatismos',2,'Fisk'),
('Köttfärsås och Spagetti',2,'Kött'),
('Fish and chips med remouladsås',3,'Fisk'),
('Stekt fläsk med löksås',3,'För köttälskare'),
('Pastagratäng med rökt kassler purjolök och cocktailtomater',3,'Pasta');



insert into ItemCategory (itemcategoryid, name, url)
VALUES (1,'Kött','url'),
(2,'Förrätt','url'),
(3,'Efterrätt','url'),
(4,'Kockens Val','url'),
(5,'Vilt','url'),
(6,'À La Carte','url'),
(7,'Dryck','url'),
(8,'fisk','url'),
(9,'vegetarisk','url');

insert into ITEM (itemid, title, price, description, type, itemcategoryid)

VALUES (4,'Tomatsoppa',115,'Ägg 63, chili, krutonger, basilika','vegetarisk',9);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (5,'Cola',115,'33CL','dryck',7);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (6,'Skakentoast',115,'Toast med skagenröra','macka',2);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (7,'Renskav',115,'Renskav med potatis','Vilt',4);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (8,'Glass',115,'3 skopor vaniljglass med colasås','glass',3);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (9,'Vildssvin',115,'Vildssvinskotlett med potatisgratäng','vilt',5);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (10,'Spagetti med kötfärsås',115,'Serveras med parmesanost','pasta',6);

VALUES (1,'Bakad fläskkarre',115,'gräddstuvad kål, senapssky, äppelmos, rostad morot','kött',1),
(2,'Oxbringa',115,'senapssås, pepparrot, rostad potatis, bakad lök, persilja','kött',1),
(3,'Fiskgryta',115,'sej, musslor, potatis, fänkål, dill, citron, aioli','fisk​',8),
(4,'Tomatsoppa',115,'Ägg 63, chili, krutonger, basilika','vegetarisk',9);

insert into Dinnertable (dinnertableid, description, sizesoftable)
VALUES (1,'Fonsterbord',4),
(2,'Salong',4),
(3,'Fonsterbord',2),
(4,'Mitten',8),
(5,'Salong',4),
(6,'Ingång',2),
(7,'Mitten',4);


insert into Customer(customerid, firstname, lastname, sizeofcompany, email, bookingtime, bookingdate, phone)
VALUES (1, 'Allan', 'Takkolander', 4, 'Test@email.com','21:30','2019-02-02', '070-3123431');  

insert into ItemOrder(orderid, amount, note, ready, dinnertableid, itemid)
VALUES (1,1,'Utan Ost',true,1,1);

