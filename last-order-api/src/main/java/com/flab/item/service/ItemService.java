package com.flab.item.service;

import com.flab.item.domain.dto.request.ItemRequest;
import com.flab.item.domain.dto.response.ItemResponse;

import java.util.List;

public interface ItemService {

    Long addItem(ItemRequest itemRequest);

    Long updateItem(ItemRequest itemRequest);

    Long deleteItem(Long itemId);

    List<ItemResponse> findItems();

    ItemResponse findItem(Long itemId);
}
