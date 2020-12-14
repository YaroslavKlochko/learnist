DROP TABLE IF EXISTS password_reset_tokens CASCADE;
CREATE TABLE password_reset_tokens (
  id      BIGSERIAL PRIMARY KEY NOT NULL,
  token   VARCHAR(200),
  user_id BIGSERIAL NOT NULL,
  expiry_date TIMESTAMP
)
