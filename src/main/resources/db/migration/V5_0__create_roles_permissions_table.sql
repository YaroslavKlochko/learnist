DROP TABLE IF EXISTS roles_permissions CASCADE;
CREATE TABLE roles_permissions (
  role_id       BIGSERIAL,
  FOREIGN KEY (role_id) REFERENCES roles (role_id),
  permission_id BIGSERIAL,
  FOREIGN KEY (permission_id) REFERENCES permissions (permission_id)
);