DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    user_id                 BIGSERIAL PRIMARY KEY NOT NULL,
    username                VARCHAR(50) UNIQUE,
    password                VARCHAR(150),
    email                   VARCHAR(100),
    enabled                 BOOLEAN               NOT NULL DEFAULT TRUE,
    account_non_expired     BOOLEAN               NOT NULL DEFAULT TRUE,
    account_non_locked      BOOLEAN                        DEFAULT TRUE,
    failed_attempt          SMALLINT                       DEFAULT 0,
    credentials_non_expired BOOLEAN,
    lock_time               DATE
);


