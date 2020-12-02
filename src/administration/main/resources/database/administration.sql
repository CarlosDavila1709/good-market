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
    grocery_id VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    prefix  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS products (
    id CHAR(36) NOT NULL,
    categorie_id VARCHAR(36) NOT NULL,
    unit_measure_id VARCHAR(36) NOT NULL,
    grocery_id VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(13, 2) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS products_catalog (
    id CHAR(36) NOT NULL,
    categorie_id CHAR(36) NOT NULL,
    unit_measure_id CHAR(36) NOT NULL,
    grocery_id VARCHAR(36) NOT NULL,
    categorie_name VARCHAR(255) NOT NULL,
    unit_measure_name VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(13, 2) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS shopping_cart (
    id CHAR(36) NOT NULL,
    session_id CHAR(36) NOT NULL,
    grocery_id VARCHAR(36) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    total_items INT NOT NULL,
    existing_products VARCHAR(10000000),
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS cart_items (
    id CHAR(36) NOT NULL,
    shopping_cart_id VARCHAR(36) NOT NULL,
    session_id CHAR(36) NOT NULL,
    grocery_id VARCHAR(36) NOT NULL,
    product_id CHAR(36) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(13, 2) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    quantity INT NOT NULL,
    unit_measure_name VARCHAR(255),
    categorie_name VARCHAR(255),
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS customers (
    id CHAR(36) NOT NULL,
    customer_phone VARCHAR(255) NOT NULL,
    customer_first_name VARCHAR(255) NOT NULL,
    customer_last_name VARCHAR(255),
    customer_middle_name VARCHAR(255),
    customer_address VARCHAR(255),
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS orders (
    id CHAR(36) NOT NULL,
    grocery_id CHAR(36) NOT NULL,
    customer_id CHAR(36) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    total_items INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    description_status VARCHAR(255) NOT NULL,
    existing_products VARCHAR(10000000),
    date_creation VARCHAR(255) NOT NULL,
    name_customer VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS order_item (
    id CHAR(36) NOT NULL,
    order_id CHAR(36) NOT NULL,
    product_id VARCHAR(36) NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_price DECIMAL(13, 2) NOT NULL,
    amount_total DECIMAL(13, 2) NOT NULL,
    quantity INT NOT NULL,
    categorie_name VARCHAR(255) NOT NULL,
    unitMeasure_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;