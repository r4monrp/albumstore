package com.ramon.pereira.albumstore.util;

import com.github.javafaker.Faker;
import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.model.enDiscGenre;
import com.ramon.pereira.albumstore.repository.DiscCatalogRepository;
import com.ramon.pereira.albumstore.services.SpotifyService;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
public class LoadDataOnStartup {

  private static final Faker faker = new Faker();

  @Autowired
  private DiscCatalogRepository discCatalogRepository;

  @Autowired
  private SpotifyService spotifyService;



  private void initData() {
    this.authenticateSpotifyService();
    this.createDisksRock();
    this.createDisksMpb();
    this.createDisksClassic();
    this.createDisksPop();
  }

  private void authenticateSpotifyService() {
    try {

      this.spotifyService.spotifyAuthenticate();

    } catch (Exception ex ) {

      System.out.println("ERROR: NO POSSIBLE AUTHENTICATE SPOTFY SERVICE" + ex);

    }
  }

  private void createDisksRock() {
    try {
      var albuns = spotifyService.getRockAlbuns();

      albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
        discCatalogRepository.saveAndFlush(Disc.builder()
            .genre(enDiscGenre.ROCK)
            .name(item.getName())
            .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
            .build());
      }));

    } catch (Exception ex) {

      System.out.println("ERROR: NO POSSIBLE LOAD DATA CREATE DISKS ROCK SPOTFY SERVICE:" + ex);

    }
  }

  private void createDisksMpb() {
    try {
      var albuns = spotifyService.getMpbAlbuns();

      albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
        discCatalogRepository.saveAndFlush(Disc.builder()
            .genre(enDiscGenre.MPB)
            .name(item.getName())
            .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
            .build());
      }));

    } catch (Exception ex) {

      System.out.println("ERROR: NO POSSIBLE LOAD DATA CREATE DISKS MPB SPOTFY SERVICE:" + ex);

    }
  }

  private void createDisksClassic() {
    try {
      var albuns = spotifyService.getClassicAlbuns();

      albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
        discCatalogRepository.saveAndFlush(Disc.builder()
            .genre(enDiscGenre.CLASSIC)
            .name(item.getName())
            .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
            .build());
      }));

    } catch (Exception ex) {

      System.out.println("ERROR: NO POSSIBLE LOAD DATA CREATE DISKS CLASSIC SPOTFY SERVICE:" + ex);

    }
  }

  private void createDisksPop() {
    try {
      var albuns = spotifyService.getPopAlbuns();

      albuns.ifPresent(albumSimplifieds -> albumSimplifieds.forEach(item -> {
        discCatalogRepository.saveAndFlush(Disc.builder()
            .genre(enDiscGenre.POP)
            .name(item.getName())
            .price(BigDecimal.valueOf(faker.number().numberBetween(1, 1000)))
            .build());
      }));

    } catch (Exception ex) {

      System.out.println("ERROR: NO POSSIBLE LOAD DATA CREATE DISKS POP SPOTFY SERVICE:" + ex);

    }
  }

}
