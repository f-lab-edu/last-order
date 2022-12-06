package com.flab.review.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String content;

    private Long userId;

    private Long orderId;

    private Long storeId;
}
