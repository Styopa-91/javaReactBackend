package com.javaReact.javaReactBackend.mapper;

import com.javaReact.javaReactBackend.dto.ItemDto;
import com.javaReact.javaReactBackend.entity.Item;

public class ItemMapper {
    public static ItemDto mapToItemDto (Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getQuantity()
        );
    }

    public static Item mapToItem (ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getQuantity()

        );
    }
}
