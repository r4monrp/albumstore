package com.ramon.pereira.albumstore.repository;

import com.ramon.pereira.albumstore.model.Disc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Disc, Integer> {
}
