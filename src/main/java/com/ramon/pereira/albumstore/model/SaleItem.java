package com.ramon.pereira.albumstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sale_items")
public class SaleItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private enDiscGenre genre;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal totalPrice;

    @Column
    private BigDecimal cashBackValue;

    @JsonBackReference
    @PrimaryKeyJoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;
}
