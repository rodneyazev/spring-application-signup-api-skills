INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (1,'USER','Default user role') ON CONFLICT (NAME) DO NOTHING;
INSERT INTO ROLES (ID, NAME, DESCRIPTION) VALUES (2,'ADMIN','Administrator role') ON CONFLICT (NAME) DO NOTHING;
--
-- Administr@t0r == $2a$10$S.NTDoAhc7Wszvfjc3Pl7O9PhUiv5rVg9zPFlz5OWLQV98iwJMQ3q
-- INSERT INTO USERS (ID, USERNAME, EMAIL, PASSWORD, ROLE_ID, CREATE_USER, CREATE_DATE) VALUES (1, 'admin', 'admin@admin.com', '$2a$10$S.NTDoAhc7Wszvfjc3Pl7O9PhUiv5rVg9zPFlz5OWLQV98iwJMQ3q', 2, 'SYSTEM', LOCALTIMESTAMP )  ON CONFLICT (USERNAME) DO NOTHING;