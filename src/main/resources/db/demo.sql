DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, last_name, birthday, login, password, about_myself, address) VALUES
  ('name', 'last_name', '2015-05-30 10:00:00' , 'login', 'password', 'about myself', 'address'),
  ('Roman', 'Abaev', '2015-05-30 10:00:00', 'roman', 'password', 'yep, it''s me', 'pr. Kos');