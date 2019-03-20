package com.ramon.pereira.albumstore.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "cashback_by_genre_and_day")
public class CashbackByGenreAndDay {

  @EmbeddedId
  private CashbackByGenreAndDayPK id;

  @Column
  private BigDecimal percentCashBack;
}
