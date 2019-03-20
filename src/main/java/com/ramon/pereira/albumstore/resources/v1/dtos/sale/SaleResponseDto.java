package com.ramon.pereira.albumstore.resources.v1.dtos.sale;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleResponseDto {
  private Integer id;
  private String customerName;
  private String customerEmail;
  private Long customerCpf;
  private List<SaleItemResponseDto> items;
  private BigDecimal totalPrice;
  private BigDecimal cashBackTotalValue;
  private ZonedDateTime createdAt;
}
