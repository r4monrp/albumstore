package com.ramon.pereira.albumstore.repository;


import com.ramon.pereira.albumstore.model.Disc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscCatalogRepository extends JpaRepository<Disc, Integer> {
}
