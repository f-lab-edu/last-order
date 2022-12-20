package com.flab.itemImage.domain;

import com.flab.item.domain.Item;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "tb_item_image")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemImage_id")
    private Long id;

    private String uploadImageName;

    private String storeImageName;

    private Long itemId;

}
