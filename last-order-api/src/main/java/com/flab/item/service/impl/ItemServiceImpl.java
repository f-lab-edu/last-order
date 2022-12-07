package com.flab.item.service.impl;

import com.flab.item.domain.Item;
import com.flab.item.domain.dto.request.ItemRequest;
import com.flab.item.domain.dto.response.ItemResponse;
import com.flab.item.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public Long addItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .id(1L)
                .name("맥북")
                .price(1880000)
                .build();
        return item.getId();
    }

    @Override
    public Long updateItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .id(1L)
                .name("맥북")
                .price(1880000)
                .build();
        return item.getId();
    }

    @Override
    public Long deleteItem(Long itemId) {
        return itemId;
    }

    @Override
    public List<ItemResponse> findItems() {
        List<Item> items = new ArrayList<>();
        Item item1 = Item.builder()
                .id(1L)
                .name("맥북")
                .price(1880000)
                .build();
        Item item2 = Item.builder()
                .id(2L)
                .name("아이폰14")
                .price(1440000)
                .build();
        items.add(item1);
        items.add(item2);
        return items.stream().map(ItemResponse::new).collect(Collectors.toList());
    }

    @Override
    public ItemResponse findItem(Long itemId) {
        Item item = Item.builder()
                .id(1L)
                .name("아메리카노")
                .price(5800)
                .description("아라비카 원두")
                .stack(300)
                .build();
        ItemResponse itemResponse = new ItemResponse(item);
        itemResponse.addStore("스타벅스");
        return itemResponse;
    }
}
