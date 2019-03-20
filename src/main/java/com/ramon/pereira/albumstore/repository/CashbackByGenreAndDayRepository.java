package com.ramon.pereira.albumstore.repository;

import com.ramon.pereira.albumstore.model.CashbackByGenreAndDay;
import com.ramon.pereira.albumstore.model.CashbackByGenreAndDayPK;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashbackByGenreAndDayRepository extends JpaRepository<CashbackByGenreAndDay, CashbackByGenreAndDayPK> {
}
