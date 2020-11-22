DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
  user_id             BIGSERIAL PRIMARY KEY NOT NULL,
  username            VARCHAR(50) UNIQUE,
  password            VARCHAR(150),
  email               VARCHAR(100),
  enabled             BOOLEAN               NOT NULL,
  account_expired     BOOLEAN               NOT NULL,
  credentials_expired BOOLEAN               NOT NULL,
  account_non_locked  BOOLEAN               NOT NULL
);
