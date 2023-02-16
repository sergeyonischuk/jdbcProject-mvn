INSERT INTO WORKER("name", birthday, "level", salary_month) VALUES ('Volodymyr', '1996-04-12', 'TRAINEE', 500),
                                                                   ('Andrii', '1979.05.21', 'SENIOR', 6000),
                                                                   ('Valerii', '1998.07.01', 'MIDDLE', 1600),
                                                                   ('Serhii', '1992.02.18', 'JUNIOR', 700),
                                                                   ('Anna', '2001.10.26', 'JUNIOR', 700),
                                                                   ('Iryna', '1994.01.23', 'MIDDLE', 2000),
                                                                   ('Veronika', '1989.07.06', 'SENIOR', 3500),
                                                                   ('Borys', '1999.07.04', 'MIDDLE', 1500),
                                                                   ('Artem', '2003.02.24', 'TRAINEE', 400),
                                                                   ('Vitalina', '1997.12.18', 'JUNIOR', 800);

INSERT INTO CLIENT("name") VALUES
('Silpo'),
('Monobank'),
('Uber'),
('McDonalds'),
('Eco Sadyba');

INSERT INTO PROJECT(start_date, finish_date, client_id) VALUES
('2021.02.15', '2023.05.15', 1),
('2022.07.16', '2024.07.15', 2),
('2020.08.10', '2023.03.10', 5),
('2022.05.01', '2025.05.01', 2),
('2022.05.09', '2023.02.09', 3),
('2022.01.01', '2023.07.01', 1),
('2023.10.27', '2027.10.27', 4),
('2021.10.30', '2024.10.30', 4),
('2019.12.01', '2023.06.01', 2),
('2018.09.08', '2023.09.01', 5);

INSERT INTO PROJECT_WORKER(project_id, worker_id) VALUES
(1, 1),
(2, 1),
(3, 3),
(4, 6),
(5, 8),
(1, 2),
(1, 3),
(2, 4),
(3, 5),
(4, 7),
(5, 9),
(5, 10),
(6, 2),
(7, 4),
(7, 9),
(8, 8),
(9, 4);