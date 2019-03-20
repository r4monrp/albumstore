package com.ramon.pereira.albumstore.business.impl;

import com.ramon.pereira.albumstore.business.SalesBusiness;
import com.ramon.pereira.albumstore.model.CashbackByGenreAndDay;
import com.ramon.pereira.albumstore.model.Sale;
import com.ramon.pereira.albumstore.model.SaleItem;
import com.ramon.pereira.albumstore.model.enDay;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.repository.CashbackByGenreAndDayRepository;
import com.ramon.pereira.albumstore.repository.SalesRepository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalesBusinessImpl implements SalesBusiness {

  @Autowired
  private SalesRepository salesRepository;

  @Autowired
  private CashbackByGenreAndDayRepository cashbackByGenreAndDayRepository;

  @Override
  public Optional<List<Sale>> findByCreatedAtBetweenOrderByCreatedAtDesc(@NonNull final ZonedDateTime startDate,
                                                                         @NonNull final ZonedDateTime endDate,
                                                                         @NonNull final Pageable pageable) {

    return salesRepository.findByCreatedAtBetweenOrderByCreatedAtDesc(startDate, endDate, pageable);

  }

  @Override
  public Optional<Sale> findById(@NonNull final Integer id) {
    return salesRepository.findById(id);
  }

  @Override
  public Optional<Sale> create(@NonNull final Sale sale) {

    Optional.of(sale.getItems())
        .ifPresent(v -> v.forEach(e -> {
          e.setCashBackValue(processCashBackValue(e));
          e.setSale(sale);
        }));

    sale.setCashBackTotalValue(calculeTotalCashbackFromSaleBySaleItems(sale.getItems()));

    return Optional.of(salesRepository.saveAndFlush(sale));
  }


  protected BigDecimal calculeTotalCashbackFromSaleBySaleItems(@NonNull final List<SaleItem> saleItems) {
    return saleItems.stream()
        .map(SaleItem::getCashBackValue)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  protected BigDecimal processCashBackValue(@NonNull final SaleItem saleItem) {
    return calculeTotalCashbackPerItem(saleItem.getTotalPrice(),
        getCashbackByGenreAndDay(saleItem.getGenre(), enDay.valueOf(ZonedDateTime.now().getDayOfWeek().toString())));
  }

  protected BigDecimal calculeTotalCashbackPerItem(@NonNull final BigDecimal totalItemPrice,
                                                   @NonNull final BigDecimal cashbackPercent) {

    return totalItemPrice.divide(new BigDecimal(100)).multiply(cashbackPercent);
  }


  protected BigDecimal getCashbackByGenreAndDay(@NonNull final enDiscGenre enDiscGenre, @NonNull final enDay enDay) {
    return cashbackByGenreAndDayRepository.findByGenreAndDay(enDiscGenre, enDay)
        .map(CashbackByGenreAndDay::getPercentCashBack)
        .orElse(BigDecimal.ZERO);
  }
}
