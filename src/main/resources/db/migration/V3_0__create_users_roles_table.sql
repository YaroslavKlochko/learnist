DROP TABLE IF EXISTS users_roles CASCADE;
CREATE TABLE users_roles (
  user_id BIGSERIAL NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  role_id BIGSERIAL NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles (role_id)

);

