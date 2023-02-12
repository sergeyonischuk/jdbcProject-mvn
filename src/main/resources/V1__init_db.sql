CREATE TYPE LVL AS ENUM('TRAINEE', 'JUNIOR', 'MIDDLE', 'SENIOR');
CREATE TABLE WORKER (
                        WORKER_ID SERIAL PRIMARY KEY NOT NULL,
                        name VARCHAR(100) CHECK (length(name) >= 2 AND length(name) <= 1000) NOT NULL,
                        birthday date CHECK (birthday > '1900-01-01'),
                        level lvl,
                        salary_month INT CHECK (salary_month >= 100 AND salary_month <= 100000));

CREATE TABLE CLIENT(
                       CLIENT_ID SERIAL PRIMARY KEY NOT NULL,
                       name VARCHAR(1000) NOT NULL CHECK (length(name) >= 2 AND length(name) <= 1000));

CREATE TABLE PROJECT(
                        PROJECT_ID SERIAL PRIMARY KEY NOT NULL,
                        client_id INT,
                        start_date date,
                        finish_date date,
                        FOREIGN KEY(client_id) REFERENCES clientAndProject(CLIENT_ID));

CREATE TABLE PROJECT_WORKER(
                               project_id INT,
                               worker_id INT,
                               PRIMARY KEY (project_id, worker_id),
                               FOREIGN KEY(project_id) REFERENCES project(PROJECT_ID),
                               FOREIGN KEY(worker_id) REFERENCES worker(WORKER_ID));