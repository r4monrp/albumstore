package com.ramon.pereira.albumstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "sales")
@NamedEntityGraph(name = "sale.detail", attributeNodes = {
        @NamedAttributeNode("items")})
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String customerName;

    @Column
    private String customerEmail;

    @Column
    private Integer customerCpf;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sales")
    @JsonManagedReference
    private List<SaleItem> items;

    @Column
    private BigDecimal totalPrice;

    @Column
    private BigDecimal cashBackTotalValue;

    @Column
    private ZonedDateTime createdAt;

    @PrePersist
    protected void prePersist() { createdAt = ZonedDateTime.now();}
}
