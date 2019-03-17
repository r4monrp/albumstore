package com.ramon.pereira.albumstore.business;

import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;

import java.util.List;
import java.util.Optional;

public interface DiscCatalogBusiness {
    Optional<List<Disc>> filterByGenre(enDiscGenre genre);

    Optional<Disc> findById(Integer id);
}
