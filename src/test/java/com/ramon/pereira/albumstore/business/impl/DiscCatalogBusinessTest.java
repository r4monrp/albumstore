package com.ramon.pereira.albumstore.business.impl;

import com.github.javafaker.Faker;
import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.config.SpringTestConfiguration;
import com.ramon.pereira.albumstore.exception.DiscNotFoundException;
import com.ramon.pereira.albumstore.repository.DiscCatalogRepository;
import com.ramon.pereira.albumstore.seed.DiscSeeder;
import com.ramon.pereira.albumstore.services.SpotifyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@TestPropertySource(properties = {"spring.config.location=classpath:application-test.yml"})
@ContextConfiguration(classes = SpringTestConfiguration.class)
@RunWith(SpringRunner.class)
public class DiscCatalogBusinessTest {

    @MockBean
    private DiscCatalogRepository discCatalogRepository;

    @MockBean
    private SpotifyService spotifyService;

    @Autowired
    private DiscCatalogBusiness discCatalogBusiness;

    private static final Faker faker = new Faker();


    @Test
    public void findByIdExist() {
        Mockito.when(this.discCatalogRepository.findById(1))
                .thenReturn(Optional.of(DiscSeeder.disc(1)));

        var disc = this.discCatalogBusiness.findById(1);

        Assert.assertTrue(disc.isPresent());
        Assert.assertNotNull(disc.get().getId());
        Assert.assertEquals(Integer.valueOf(1), disc.get().getId());
    }

    @Test(expected = DiscNotFoundException.class)
    public void findByIdNotExist() {
        Mockito.when(this.discCatalogRepository.findById(ArgumentMatchers.anyInt()))
                .thenThrow(new DiscNotFoundException());

        this.discCatalogBusiness.findById(1);
    }

}
