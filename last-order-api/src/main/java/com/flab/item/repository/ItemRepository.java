package com.flab.item.repository;

import com.flab.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Override
    Optional<Item> findById(Long itemId);

    void deleteById(Long itemId);
}
