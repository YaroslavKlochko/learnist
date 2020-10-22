DROP TABLE IF EXISTS persistent_logins CASCADE;
CREATE TABLE persistent_logins (
    username  VARCHAR(50),
    series    VARCHAR(64) PRIMARY KEY,
    token     VARCHAR(64) NOT NULL,
    last_used TIMESTAMP   NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);