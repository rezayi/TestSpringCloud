-- categories
INSERT INTO "categories" ("id", "name")
VALUES (1, 'books');
INSERT INTO "categories" ("id", "name")
VALUES (2, 'shoes');
-- -- products
INSERT INTO "products" ("id", "name", "categoryId", "price")
VALUES (1, 'book1', 1, 200);
INSERT INTO "products" ("id", "name", "categoryId", "price")
VALUES (2, 'book2', 1, 230);
INSERT INTO "products" ("id", "name", "categoryId", "price")
VALUES (3, 'book3', 1, 235);

INSERT INTO "products" ("id", "name", "categoryId", "price")
VALUES (4, 'shoe1', 2, 235);
INSERT INTO "products" ("id", "name", "categoryId", "price")
VALUES (5, 'shoe2', 2, 235);