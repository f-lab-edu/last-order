package com.flab.address.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_address")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private Long latitude;

    private Long longitude;

}
