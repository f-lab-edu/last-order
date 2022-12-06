package com.flab.item.domain;

import com.flab.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private String description;

    private Long userId;

    private Integer stack;

    private Long storeId;

}
