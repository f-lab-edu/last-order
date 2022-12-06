package com.flab.reply.domani;

import com.flab.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    private String content;

    private Long userId;

    private Long reviewId;
}
