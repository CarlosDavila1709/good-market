CREATE TABLE  IF NOT EXISTS auth_users (
    id CHAR(36) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
	grocery_id VARCHAR(36) NOT NULL,
	oauth_company VARCHAR(255) NOT NULL,
	oauth_external BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) ;
CREATE TABLE  IF NOT EXISTS grocerys (
    id CHAR(36) NOT NULL,
    name_commercial VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
	active VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;