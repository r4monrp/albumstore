CREATE TABLE albumstore.sale_items (
  sale_id INT NOT NULL,
  id INT NOT NULL,
  name VARCHAR(300) NOT NULL,
  genre SMALLINT NOT NULL,
  quantity INT(11) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  total_price DECIMAL(10,2) NOT NULL,
  cash_back_value DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_SALE_ITEM_SALE FOREIGN KEY (sale_id) REFERENCES sales (id)
);
