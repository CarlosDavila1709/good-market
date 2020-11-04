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
CREATE TABLE  IF NOT EXISTS products_catalog (
    id CHAR(36) NOT NULL,
    categorie_id CHAR(36) NOT NULL,
    unit_measure_id CHAR(36) NOT NULL,
    categorie_name VARCHAR(255) NOT NULL,
    unit_measure_name VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(13, 2) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS shopping_cart (
    id CHAR(36) NOT NULL,
    session_id CHAR(36) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    total_items INT NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS cart_items (
    id CHAR(36) NOT NULL,
    session_id CHAR(36) NOT NULL,
    product_id CHAR(36) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(13, 2) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
) ;
