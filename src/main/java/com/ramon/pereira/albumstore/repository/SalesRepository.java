package com.ramon.pereira.albumstore.repository;

import com.ramon.pereira.albumstore.model.Sale;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Integer> {

  Optional<List<Sale>> findByCreatedAtBetweenOrderByCreatedAtDesc(@NonNull final ZonedDateTime startDate,
                                                                  @NonNull final ZonedDateTime endDate,
                                                                  @NonNull final Pageable pageable);
}
