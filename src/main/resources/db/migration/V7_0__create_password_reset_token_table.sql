DROP TABLE IF EXISTS password_reset_token CASCADE;
CREATE TABLE password_reset_token (
  id      BIGSERIAL PRIMARY KEY NOT NULL,
  token   VARCHAR(200),
  user_id BIGSERIAL,
  expiry_date TIMESTAMP
)