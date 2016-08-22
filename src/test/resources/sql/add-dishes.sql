INSERT INTO category(categoryId,name) VALUES (1,'lunch');
INSERT INTO category(categoryId,name) VALUES (2,'salad');

INSERT INTO partner(type, name, phone, status, surName) VALUES ('chef', 'Gago', '37455555555', 'ACTIVE', 'Gago');
INSERT INTO name (en,hy,ru) VALUES ('lunch1', 'լանչ1', 'ланч1');
INSERT INTO description (en,am,ru) VALUES ('dish1 description', 'блюда1 description', 'ուտելիք1 description');
INSERT INTO dish(chefPrice, descriptionId, dishStatus, nameId, price, partnerId) VALUES (100,'1', 'ACTIVE', '1','120',1)

INSERT INTO partner(type, name, phone, status, surName) VALUES ('chef', 'Gugo', '37455000000', 'ACTIVE', 'Gugo');
INSERT INTO name (en,hy,ru) VALUES ('salad1','աղցան1', 'салат1');
INSERT INTO description (en,am,ru) VALUES ('dish2 description', 'блюда2 description', 'ուտելիք2 description');
INSERT INTO dish(chefPrice, descriptionId, dishStatus, nameId, price, partnerId) VALUES (100,1, 'ACTIVE', 2,'120',2);

INSERT INTO dishCategory (categoryId, dishId) VALUES (1,1);
INSERT INTO dishCategory (categoryId, dishId) VALUES (2,2);