DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
  id       BIGSERIAL PRIMARY KEY NOT NULL,
  username VARCHAR(50),
  password VARCHAR(150),
  enabled             BOOLEAN            NOT NULL,
  account_expired     BOOLEAN            NOT NULL,
  credentials_expired BOOLEAN            NOT NULL,
  account_non_locked  BOOLEAN            NOT NULL
);