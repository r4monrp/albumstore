package com.ramon.pereira.albumstore.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CashbackByGenreAndDayPK implements Serializable {

  @Column(name = "genre")
  @Enumerated(EnumType.ORDINAL)
  private enDiscGenre genre;


  @Column(name = "day")
  @Enumerated(EnumType.ORDINAL)
  private enDay day;
}
