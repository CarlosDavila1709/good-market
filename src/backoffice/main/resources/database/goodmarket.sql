CREATE TABLE  IF NOT EXISTS grocerys (
    id CHAR(36) NOT NULL,
    name_commercial VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
	active VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ;