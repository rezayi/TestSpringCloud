CREATE TABLE IF NOT EXISTS "categories"
(
    "id"   IDENTITY     NOT NULL,
    "name" VARCHAR(128) NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "products"
(
    "id"         IDENTITY     NOT NULL,
    "name"       VARCHAR(128) NOT NULL,
    "categoryId" INTEGER      NOT NULL,
    "price"      INTEGER      NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY ("categoryId") REFERENCES "categories" ("id")
);