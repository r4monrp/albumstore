package com.ramon.pereira.albumstore.business;

import com.ramon.pereira.albumstore.model.Sale;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.data.domain.Pageable;

public interface SalesBusiness {

  Optional<List<Sale>> findByCreatedAtBetweenOrderByCreatedAtDesc(@NonNull final ZonedDateTime startDate,
                                                                  @NonNull final ZonedDateTime endDate,
                                                                  @NonNull final Pageable pageable);

  Optional<Sale> findById(@NonNull final Integer id);

  Optional<Sale> create(@NonNull final Sale sale);
}
