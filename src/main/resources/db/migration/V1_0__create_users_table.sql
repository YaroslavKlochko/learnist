DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users(
                      user_id             BIGSERIAL PRIMARY KEY NOT NULL,
                      username            VARCHAR(50) UNIQUE,
                      password            VARCHAR(150),
                      email               VARCHAR(100),
                      enabled             BOOLEAN               NOT NULL DEFAULT TRUE,
                      account_expired     BOOLEAN               NOT NULL DEFAULT TRUE,
                      credentials_expired BOOLEAN               NOT NULL DEFAULT TRUE,
                      account_non_locked  BOOLEAN               NOT NULL DEFAULT TRUE
);
