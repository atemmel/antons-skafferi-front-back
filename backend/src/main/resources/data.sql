/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fredriksellgren
 * Created: 2 dec. 2019
 */

insert into ItemCategory (itemcategoryid, name, url) VALUES (1,'Kött','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (2,'Förrätt','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (3,'Efterrätt','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (4,'Kockens Val','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (5,'Vilt','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (6,'À La Carte','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (7,'Dryck','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (8,'fisk','url');
insert into ItemCategory (itemcategoryid, name, url) VALUES (9,'vegetarisk','url');

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (1,'Bakad fläskkarre',115,'gräddstuvad kål, senapssky, äppelmos, rostad morot','kött',1);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (2,'Oxbringa',115,'senapssås, pepparrot, rostad potatis, bakad lök, persilja','kött',1);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (3,'Fiskgryta',115,'sej, musslor, potatis, fänkål, dill, citron, aioli','fisk​',8);

insert into ITEM (itemid, title, price, description, type, itemcategoryid)
VALUES (4,'Tomatsoppa',115,'Ägg 63, chili, krutonger, basilika','vegetarisk',9);