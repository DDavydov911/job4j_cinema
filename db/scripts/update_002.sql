
INSERT INTO sessions(name) VALUES ('Great Seven');
INSERT INTO sessions(name) VALUES ('1 + 1');
INSERT INTO sessions(name) VALUES ('Odissey');
INSERT INTO sessions(name) VALUES('Last from Mohegans');

INSERT INTO users(username, email, phone, password) VALUES('Sasha', '123@mail.com', '12345678', '123');
INSERT INTO users(username, email, phone, password) VALUES('Dasha', '223@mail.com', '22345678', '223');
INSERT INTO users(username, email, phone, password) VALUES('Masha', '323@mail.com', '32345678', '323');
INSERT INTO users(username, email, phone, password) VALUES('Gosha', '423@mail.com', '42345678', '423');

INSERT INTO tickets(session_id, `row`, cell, user_id)
VALUES
       (1, 1, 1, 1),
       (1, 1, 2, 2),
       (1, 1, 3, 3),
       (1, 1, 4, 4);
