package com.flab.favorite.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_favorite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long id;

    private Long userId;

    private Long storeId;

}
