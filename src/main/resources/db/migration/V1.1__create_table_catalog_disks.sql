CREATE TABLE albumstore.catalog_disks (
  id INT NOT NULL,
  name VARCHAR(300) NOT NULL,
  genre SMALLINT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);
