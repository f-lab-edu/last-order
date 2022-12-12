package com.flab.item.service;

import com.flab.item.domain.Item;
import com.flab.item.domain.dto.request.ItemRequest;
import com.flab.item.domain.dto.response.ItemResponse;
import com.flab.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Long addItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .name(itemRequest.getName())
                .price(itemRequest.getPrice())
                .stack(itemRequest.getStack())
                .description(itemRequest.getDescription())
                .build();

        return itemRepository.save(item).getId();
    }

    public Long updateItem(Long itemId, ItemRequest itemRequest) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException());
        item.update(itemRequest.getName(), itemRequest.getPrice(), itemRequest.getDescription(), itemRequest.getStack());
        return item.getId();
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
    
    public List<ItemResponse> findItems() {
        return itemRepository.findAll().stream().map(ItemResponse::new).collect(Collectors.toList());
    }

    public ItemResponse findItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException());
        return new ItemResponse(item);
    }
}
