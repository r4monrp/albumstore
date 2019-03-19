package com.ramon.pereira.albumstore.model;

import lombok.Getter;

@Getter
public enum enDay {
  SUNDAY(1),
  MONDAY(2),
  TUESDAY(3),
  WEDNESDAY(4),
  THURSDAY(5),
  FRIDAY(6),
  SATURDAY(7);

  private Integer id;

  enDay(Integer id) {
    this.id = id;
  }
}