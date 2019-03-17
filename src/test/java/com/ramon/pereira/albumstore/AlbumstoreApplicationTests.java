package com.ramon.pereira.albumstore;

import com.ramon.pereira.albumstore.services.SpotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumstoreApplicationTests {

	@Autowired
	private SpotifyService spotifyService;

	@Test
	public void contextLoads() {

	}

}
