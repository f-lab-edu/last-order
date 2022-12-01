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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
}
