package com.javaReact.javaReactBackend.service;

import com.javaReact.javaReactBackend.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto createItem(ItemDto itemDto);

    ItemDto getItemById(Long itemId);

    List<ItemDto> getAllItems();

    ItemDto updateItem(Long ItemId, ItemDto UpdatedItem);

    void deleteItem(Long ItemId);

    ItemDto buyItem(Long itemId, ItemDto updatedItem);
}
