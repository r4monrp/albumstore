package com.ramon.pereira.albumstore.business.impl;

import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.repository.DiscCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscCatalogBusinessImpl implements DiscCatalogBusiness {

    @Autowired
    private DiscCatalogRepository discCatalogRepository;

    @Override
    public Optional<List<Disc>> filterByGenre(enDiscGenre genre) {
        return Optional.of(this.discCatalogRepository.findByGenre(genre));
    }

    @Override
    public Optional<Disc> findById(Integer id) {
        return this.discCatalogRepository.findById(id);
    }
}
