CREATE TABLE  IF NOT EXISTS grocerys (
    id CHAR(36) NOT NULL,
    name_commercial VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
	active VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS categories (
    id CHAR(36) NOT NULL,
    grocery_id VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS unit_measures (
    id CHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    prefix  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS products (
    id CHAR(36) NOT NULL,
    categorie_id VARCHAR(36) NOT NULL,
    unit_measure_id VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(13, 2) NOT NULL,
    PRIMARY KEY (id)
) ;



