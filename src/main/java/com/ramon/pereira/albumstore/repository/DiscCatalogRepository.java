package com.ramon.pereira.albumstore.repository;


import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscCatalogRepository extends JpaRepository<Disc, Integer> {

    List<Disc> findByGenre(@NonNull final enDiscGenre genre, @NonNull final Pageable pageable);
}
