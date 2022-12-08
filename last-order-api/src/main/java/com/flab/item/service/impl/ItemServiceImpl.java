package com.flab.item.service.impl;

import com.flab.item.domain.Item;
import com.flab.item.domain.dto.request.ItemRequest;
import com.flab.item.domain.dto.response.ItemResponse;
import com.flab.item.repository.ItemRepository;
import com.flab.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Long addItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .name(itemRequest.getName())
                .price(itemRequest.getPrice())
                .stack(itemRequest.getStack())
                .description(itemRequest.getDescription())
                .storeId(1L) // store id 조회하여 값 주입
                .build();

        return itemRepository.save(item).getId();
    }

    @Override
    public Long updateItem(Long itemId, ItemRequest itemRequest) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException());
        item.update(itemRequest.getName(), itemRequest.getPrice(), itemRequest.getDescription(), itemRequest.getStack());
        return item.getId();
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
    
    @Override
    public List<ItemResponse> findItems() {
        return itemRepository.findAll().stream().map(ItemResponse::new).collect(Collectors.toList());
    }

    @Override
    public ItemResponse findItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException());
        return new ItemResponse(item);
    }
}
