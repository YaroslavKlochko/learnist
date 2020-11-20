DROP TABLE IF EXISTS permissions CASCADE;
CREATE TABLE permissions (
  permission_id BIGSERIAL PRIMARY KEY NOT NULL,
  name          VARCHAR(60)
);
