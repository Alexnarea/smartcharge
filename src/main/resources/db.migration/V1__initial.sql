CREATE TABLE IF NOT EXISTS user
(
    id        INT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    age       INT NOT NULL,
    telephone VARCHAR(100),
    email     VARCHAR(255) NOT NULL,

    );