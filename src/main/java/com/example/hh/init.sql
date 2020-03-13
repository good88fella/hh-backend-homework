CREATE ROLE hh_admin WITH PASSWORD 'qwerty';
ALTER ROLE hh_admin WITH LOGIN;

CREATE DATABASE hh_backend OWNER hh_admin;
\c hh_backend;

SET ROLE hh_admin;

CREATE OR REPLACE FUNCTION update_changetimestamp_column()
    RETURNS TRIGGER AS
$$
BEGIN
    NEW.update_date = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TABLE company
(
    company_id  serial,
    name        VARCHAR(150) NOT NULL,
    create_date timestamp    NOT NULL DEFAULT NOW(),
    update_date timestamp    NOT NULL DEFAULT NOW(),
    PRIMARY KEY (company_id)
);

CREATE TRIGGER update_company_changetimestamp
    BEFORE UPDATE
    ON company
    FOR EACH ROW
EXECUTE PROCEDURE
    update_changetimestamp_column();

CREATE TABLE users
(
    user_id     serial,
    name        VARCHAR(100) NOT NULL,
    user_type   VARCHAR(10)  NOT NULL,
    company_id  INTEGER,
    create_date timestamp    NOT NULL DEFAULT NOW(),
    update_date timestamp    NOT NULL DEFAULT NOW(),
    PRIMARY KEY (user_id),
    FOREIGN KEY (company_id) REFERENCES company (company_id)
);

CREATE TRIGGER update_user_changetimestamp
    BEFORE UPDATE
    ON users
    FOR EACH ROW
EXECUTE PROCEDURE
    update_changetimestamp_column();

CREATE TABLE resume
(
    resume_id   serial,
    title       VARCHAR(100)  NOT NULL,
    user_id     INTEGER       NOT NULL,
    experience  VARCHAR(1000) NOT NULL,
    contacts    VARCHAR(200)  NOT NULL,
    create_date timestamp     NOT NULL DEFAULT NOW(),
    update_date timestamp     NOT NULL DEFAULT NOW(),
    PRIMARY KEY (resume_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TRIGGER update_resume_changetimestamp
    BEFORE UPDATE
    ON resume
    FOR EACH ROW
EXECUTE PROCEDURE
    update_changetimestamp_column();

CREATE TABLE vacancy
(
    vacancy_id  serial,
    title       VARCHAR(150)  NOT NULL,
    company_id  INTEGER       NOT NULL,
    salary      INTEGER,
    description VARCHAR(1000) NOT NULL,
    contacts    VARCHAR(200)  NOT NULL,
    create_date timestamp     NOT NULL DEFAULT NOW(),
    update_date timestamp     NOT NULL DEFAULT NOW(),
    PRIMARY KEY (vacancy_id),
    FOREIGN KEY (company_id) REFERENCES company (company_id)
);

CREATE TRIGGER update_vacancy_changetimestamp
    BEFORE UPDATE
    ON vacancy
    FOR EACH ROW
EXECUTE PROCEDURE
    update_changetimestamp_column();
