package com.ramon.pereira.albumstore.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cashback_by_genre_and_day")
public class CashbackByGenreAndDay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Enumerated(EnumType.ORDINAL)
  private enDiscGenre genre;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private enDay day;

  @Column
  private BigDecimal percentCashBack;
}
