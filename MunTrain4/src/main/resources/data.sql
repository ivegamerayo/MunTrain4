INSERT INTO USER (email, login, password) VALUES
('a','b','c'),
('Rafael','Málaga','España'),
('Corto','Maltés', 'Corn');

INSERT INTO EXAMTEMPLATE (descriptionET, publisher) VALUES
('Template1',FALSE),
('Template2',TRUE);

INSERT INTO QUESTION (description, id_examtemplate) VALUES
('Prueba?', 1),
('Try?', 2),
('Toma?', 1);

INSERT INTO RESPONSE (descriptionR, image, value, id_question) VALUES
('Prueba1','url',TRUE, 1),
('Prueba2','url',FALSE, 1),
('Try1','url',FALSE, 2),
('Try2','url',TRUE, 2),
('Toma1','url',TRUE, 3),
('Toma2','url',FALSE, 3);





