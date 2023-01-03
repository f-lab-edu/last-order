package com.flab.favorite.repository;

import com.flab.favorite.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findAllByUserId(Long userId);

    Boolean existsByUserIdAndStoreId(Long userId, Long storeId);
}
