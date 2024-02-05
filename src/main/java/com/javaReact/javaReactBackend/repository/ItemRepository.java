package com.javaReact.javaReactBackend.repository;

import com.javaReact.javaReactBackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
