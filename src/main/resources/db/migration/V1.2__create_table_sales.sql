CREATE TABLE albumstore.sales (
  id INT NOT NULL,
  customer_name VARCHAR(300) NOT NULL,
  customer_email VARCHAR(300) NOT NULL,
  customer_cpf INT(11) NOT NULL,
  total_price DECIMAL(10,2) NOT NULL,
  cash_back_total_value DECIMAL(10,2) NOT NULL,
  created_at DATETIME NOT NULL,
  PRIMARY KEY (id)
);