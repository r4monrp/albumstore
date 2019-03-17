package com.ramon.pereira.albumstore.repository;


import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.List;

@Repository
public interface DiscCatalogRepository extends JpaRepository<Disc, Integer> {

    @OrderBy("name ASC")
    List<Disc> findByGenre(enDiscGenre genre);
}
