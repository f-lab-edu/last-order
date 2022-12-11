package com.flab.store.domain;

import com.flab.store.domain.enums.StoreStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_store")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    private String storeName;

    private String address;

    private String description;

    private Integer minimumOrderAmount;

    private Integer reviewCount;

    private Integer reviewScore;

    private StoreStatus storeStatus;

    private Long ownerId;
}
