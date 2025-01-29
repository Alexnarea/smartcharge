CREATE TABLE IF NOT EXISTS user (
    id        INT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    age       INT NOT NULL,
    telephone VARCHAR(100),
    email     VARCHAR(255) NOT NULL,
    )
CREATE TABLE IF NOT EXISTS events (
    id       INT PRIMARY KEY,
    battery  INT NOT NULL,
    km       DECIMAL(10,2) NOT NULL,
    time     TIME NOT NULL
    );
CREATE TABLE IF NOT EXISTS roles (
    id   INT PRIMARY KEY,
    fullnameAdmin VARCHAR(50) NOT NULL
    User_id INT
    );

