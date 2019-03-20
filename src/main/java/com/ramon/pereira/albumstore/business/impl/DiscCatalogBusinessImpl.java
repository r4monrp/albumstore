package com.ramon.pereira.albumstore.business.impl;

import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.exception.DiscNotFoundException;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.repository.DiscCatalogRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscCatalogBusinessImpl implements DiscCatalogBusiness {

  @Autowired
  private DiscCatalogRepository discCatalogRepository;

  @Override
  public Optional<List<Disc>> findByGenreOrderByNameAsc(@NonNull final enDiscGenre genre,
                                                        @NonNull final Pageable pageable) {

    return this.discCatalogRepository.findByGenreOrderByNameAsc(genre, pageable);
  }

  @Override
  public Optional<Disc> findById(@NonNull final Integer id) {
    return Optional.of(this.discCatalogRepository.findById(id).orElseThrow(DiscNotFoundException::new));
  }
}
