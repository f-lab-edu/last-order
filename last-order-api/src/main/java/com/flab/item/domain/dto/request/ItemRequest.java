package com.flab.item.domain.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemRequest {

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    @Min(value = 100, message = "가격은 최소 100원 이상입니다.")
    @NotNull(message = "가격은 필수 입력값입니다.")
    private Integer price;

    @NotBlank(message = "설명은 필수 입력값입니다.")
    private String description;

    private Long userId;

    @Min(value = 1, message = "수량은 1개 이상 등록해야 합니다.")
    @NotNull(message = "수량은 필수 입려값 입니다.")
    private Integer stack;

    private Long storeId;
}
