CREATE TABLE IF NOT EXISTS "users"
(
    "id"           IDENTITY      NOT NULL,
    "username"     VARCHAR(128) NOT NULL,
    "passwordHash" VARCHAR(128) NOT NULL,
    "firstName"    VARCHAR(128) NOT NULL,
    "lastName"     VARCHAR(128) NOT NULL,
    PRIMARY KEY ("id")
);