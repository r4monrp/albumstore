package com.ramon.pereira.albumstore.resources.v1.dtos.sale;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
public class SaleRequestDto {

  @Valid
  @NotNull
  private String customerName;

  @Valid
  @NotNull
  private String customerEmail;

  @Valid
  @NotNull
  private Long customerCpf;

  @Valid
  @NotNull
  private List<SaleItemRequestDto> items;

  @Valid
  @NotNull
  private BigDecimal totalPrice;
}
