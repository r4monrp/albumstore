CREATE TABLE albumstore.cashback_by_genre_and_day (
  genre SMALLINT NOT NULL,
  day SMALLINT NOT NULL,
  percent_cash_back DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (genre,day)
);
