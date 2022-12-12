package com.flab.item.controller;

import com.flab.item.domain.dto.request.ItemRequest;
import com.flab.item.domain.dto.response.ItemResponse;
import com.flab.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addItem(@RequestBody @Valid ItemRequest itemRequest) {
        return itemService.addItem(itemRequest);
    }

    @PostMapping("/{itemId}")
    public Long updateItem(@PathVariable Long itemId, @RequestBody @Valid ItemRequest itemRequest) {
        return itemService.updateItem(itemId, itemRequest);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }

    @GetMapping
    public List<ItemResponse> findItems() {
        return itemService.findItems();
    }

    @GetMapping("/{itemId}")
    public ItemResponse findItem(@PathVariable Long itemId) {
        return itemService.findItem(itemId);
    }

}
