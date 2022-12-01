package com.flab.item.controller;

import com.flab.item.domain.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @PostMapping("/add")
    public Item addItem() {
        Item item = Item.builder()
                .id(1L)
                .name("맥북")
                .price(1880000)
                .build();
        return item;
    }

    @PostMapping("/update")
    public String updateItem() {
        return "update";
    }

    @DeleteMapping("/delete")
    public String deleteItem() {
        return "delete";
    }

    @GetMapping("/list")
    public List<Item> getItems() {
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

        return items;
    }

}
