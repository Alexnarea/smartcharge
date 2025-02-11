CREATE TABLE IF NOT EXISTS users (
    id         SERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE,
    password  VARCHAR(250),
    email     VARCHAR(50) NOT NULL UNIQUE,
    locked     BOOLEAN NOT NULL,
    disabled   BOOLEAN NOT NULL,
    );

CREATE TABLE IF NOT EXISTS roles (
    id        SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE,
    users_id    INT UNIQUE REFERENCES users(id)
    );


CREATE TABLE IF NOT EXISTS person (
    id         SERIAL PRIMARY KEY,
    full_name  VARCHAR(250) NOT NULL,
    age        INT NOT NULL CHECK (age >= 0),
    telephone  VARCHAR(100),
    email      VARCHAR(250) NOT NULL,
    users_id    INT UNIQUE REFERENCES users(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS device (
    id          SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS events (
    id        SERIAL PRIMARY KEY,
    battery   INT NOT NULL CHECK (battery BETWEEN 0 AND 100),
    time      TIME NOT NULL,
    person_id INT REFERENCES person(id) ON DELETE CASCADE,
    device_id INT REFERENCES device(id) ON DELETE CASCADE
    );

CREATE TABLE permission
(
    id            SERIAL ,
    resource_path VARCHAR(255) NOT NULL,
    http_method   VARCHAR(10)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role_permission
(
    role_id       INT,
    permission_id INT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)
);
