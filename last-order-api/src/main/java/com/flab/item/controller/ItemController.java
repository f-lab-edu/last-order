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
    public ResponseEntity<Long> addItem(@Valid ItemRequest itemRequest) {
        return new ResponseEntity<>(itemService.addItem(itemRequest), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updateItem(@Valid ItemRequest itemRequest) {
        return new ResponseEntity<>(itemService.updateItem(itemRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long itemId) {
        return new ResponseEntity<>(itemService.deleteItem(itemId), HttpStatus.OK);
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
