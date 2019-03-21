package com.ramon.pereira.albumstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumstoreApplicationTests {

  @Test
  public void main() {
   AlbumstoreApplication.main(new String[] {"--spring.config.location=classpath:application-test.yml"});
  }
}
