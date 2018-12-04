CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER                     COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(150)       NOT NULL COMMENT 'Наименование',
    full_name  VARCHAR(200)       NOT NULL COMMENT 'Полное наименование',
    inn        VARCHAR(20) UNIQUE NOT NULL COMMENT 'ИНН',
    kpp        VARCHAR(20) UNIQUE NOT NULL COMMENT 'КПП',
    address    VARCHAR(150)       NOT NULL COMMENT 'Адрес',
    phone      VARCHAR(20)                 COMMENT 'Телефон',
    is_active  BOOLEAN
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Employee (
    id              INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    office_id       INTEGER     NOT NULL COMMENT 'Офис',
    first_name      VARCHAR(75) NOT NULL COMMENT 'Имя',
    second_name     VARCHAR(75) NOT NULL COMMENT 'Фамилия',
    middle_name     VARCHAR(75) NOT NULL COMMENT 'Отчество',
    employee_position   VARCHAR(20) NOT NULL COMMENT 'Должность',
    doc_type_id     INTEGER     NOT NULL COMMENT 'Тип документа',
    doc_date        DATE                 COMMENT 'Дата документа',
    citizenship_id  INTEGER     NOT NULL COMMENT 'Гражданство',
    is_identified   BOOLEAN
);
COMMENT ON TABLE Employee IS 'Сотрудник';

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    org_id     INTEGER     NOT NULL COMMENT 'Организация',
    name       VARCHAR(50) NOT NULL COMMENT 'Наименование',
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone      VARCHAR(20)          COMMENT 'Телефон',
    is_active  BOOLEAN
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Document (
    id         INTEGER                     COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name       VARCHAR(50) UNIQUE NOT NULL COMMENT 'Наименование документа',
    code       VARCHAR(2)  UNIQUE NOT NULL COMMENT 'Код документа'
);
COMMENT ON TABLE Office IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Citizenship (
    id      INTEGER                     COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name    VARCHAR(50) UNIQUE NOT NULL COMMENT 'Гражданство',
    code    VARCHAR(2)  UNIQUE NOT NULL COMMENT 'Код страны'
);
COMMENT ON TABLE Office IS 'Гражданство';

CREATE INDEX IX_Organization_Id ON Organization (id);
CREATE INDEX IX_Organization_Full_Name ON Organization (full_name);
CREATE INDEX UX_Organization_Inn ON Organization (inn);
CREATE INDEX UX_Organization_Kpp ON Organization (kpp);


CREATE INDEX IX_Employee_Id ON Employee (id);
CREATE INDEX IX_Employee_First_Name ON Employee (first_name);
CREATE INDEX IX_Employee_Second_Name ON Employee (second_name);
CREATE INDEX IX_Employee_Middle_Name ON Employee (middle_name);
CREATE INDEX IX_Employee_Employee_Position ON Employee (employee_position);
ALTER TABLE Employee ADD FOREIGN KEY (doc_type_id) REFERENCES Document(id);
ALTER TABLE Employee ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_Id ON Office (id);
CREATE INDEX IX_Office_Name ON Office (name);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);