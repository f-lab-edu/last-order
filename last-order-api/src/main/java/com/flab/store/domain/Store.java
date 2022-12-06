package com.flab.store.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_store")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String storeName;

    private String description;

    private Integer minimumOrderAmount;

    private Integer reviewCount;

    private Integer reviewScore;

}
