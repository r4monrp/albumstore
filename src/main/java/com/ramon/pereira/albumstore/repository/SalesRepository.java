package com.ramon.pereira.albumstore.repository;

import com.ramon.pereira.albumstore.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Integer> {
}
