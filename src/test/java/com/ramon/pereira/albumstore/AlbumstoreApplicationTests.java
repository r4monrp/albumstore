package com.ramon.pereira.albumstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class AlbumstoreApplicationTests {

  @Test
  public void main() {
    AlbumstoreApplication.main(new String[] {"--spring.config.location=classpath:application-test.yml"});
  }
}
