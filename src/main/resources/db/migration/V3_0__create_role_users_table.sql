DROP TABLE IF EXISTS role_users CASCADE;
CREATE TABLE role_users
(
  role_id BIGSERIAL,
  FOREIGN KEY (role_id) REFERENCES role (id),
  user_id BIGSERIAL,
  FOREIGN KEY (user_id) REFERENCES users (id)
);
