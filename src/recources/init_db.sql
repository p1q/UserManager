    DROP TABLE IF EXISTS users;
    DROP SEQUENCE IF EXISTS global_seq;

    CREATE SEQUENCE global_seq
      START 100000;

    CREATE TABLE users
    (
      id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
      name          VARCHAR       NOT NULL,
      last_name     VARCHAR       NOT NULL,
      birthday      TIMESTAMP     NOT NULL,
      login         VARCHAR       NOT NULL,
      password      VARCHAR       NOT NULL,
      about_myself  VARCHAR       NOT NULL,
      address       VARCHAR       NOT NULL
    );

    CREATE UNIQUE INDEX users_unique_login_idx
      ON users (login);