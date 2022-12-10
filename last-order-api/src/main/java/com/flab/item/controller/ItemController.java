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
    public ResponseEntity<Long> addItem(@RequestBody @Valid ItemRequest itemRequest) {
        return new ResponseEntity<>(itemService.addItem(itemRequest), HttpStatus.CREATED);
    }

    @PostMapping("/{itemId}")
    public ResponseEntity<Long> updateItem(@PathVariable Long itemId, @RequestBody @Valid ItemRequest itemRequest) {
        return new ResponseEntity<>(itemService.updateItem(itemId, itemRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> findItems() {
        return new ResponseEntity<>(itemService.findItems(), HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> findItem(@PathVariable Long itemId) {
        return new ResponseEntity<>(itemService.findItem(itemId), HttpStatus.OK);
    }

}
