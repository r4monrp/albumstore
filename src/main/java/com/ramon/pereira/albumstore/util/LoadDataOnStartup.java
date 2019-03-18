package com.ramon.pereira.albumstore.util;

import com.github.javafaker.Faker;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.repository.DiscCatalogRepository;
import com.ramon.pereira.albumstore.services.SpotifyService;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadDataOnStartup implements ApplicationListener<ContextRefreshedEvent> {

  private static final Faker faker = new Faker();

  @Autowired
  private DiscCatalogRepository discCatalogRepository;

  @Autowired
  private SpotifyService spotifyService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    try {
      initData();
    } catch (IOException | SpotifyWebApiException e) {
      e.printStackTrace();
    }
  }

  private void initData() throws IOException, SpotifyWebApiException {
    this.createDisksRock();
    this.createDisksMpb();
    this.createDisksClassic();
    this.createDisksPop();
  }

  private void createDisksRock() throws IOException, SpotifyWebApiException {

    var albuns = spotifyService.getRockAlbuns();

    albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
      discCatalogRepository.saveAndFlush(Disc.builder()
          .genre(enDiscGenre.ROCK)
          .name(item.getName())
          .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
          .build());
    }));

  }

  private void createDisksMpb() throws IOException, SpotifyWebApiException {

    var albuns = spotifyService.getMpbAlbuns();

    albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
      discCatalogRepository.saveAndFlush(Disc.builder()
          .genre(enDiscGenre.MPB)
          .name(item.getName())
          .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
          .build());
    }));

  }

  private void createDisksClassic() throws IOException, SpotifyWebApiException {

    var albuns = spotifyService.getClassicAlbuns();

    albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
      discCatalogRepository.saveAndFlush(Disc.builder()
          .genre(enDiscGenre.CLASSIC)
          .name(item.getName())
          .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
          .build());
    }));

  }

  private void createDisksPop() throws IOException, SpotifyWebApiException {

    var albuns = spotifyService.getPopAlbuns();

    albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
      discCatalogRepository.saveAndFlush(Disc.builder()
          .genre(enDiscGenre.POP)
          .name(item.getName())
          .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
          .build());
    }));

  }

}
