package com.javaReact.javaReactBackend.service.impl;

import com.javaReact.javaReactBackend.dto.ItemDto;
import com.javaReact.javaReactBackend.entity.Item;
import com.javaReact.javaReactBackend.exception.ResourceNotFoundException;
import com.javaReact.javaReactBackend.mapper.ItemMapper;
import com.javaReact.javaReactBackend.repository.ItemRepository;
import com.javaReact.javaReactBackend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;
    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = ItemMapper.mapToItem(itemDto);
        Item savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }

    @Override
    public ItemDto getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item is not exists with given id : " + itemId));
        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List <Item> items = itemRepository.findAll();
        return items.stream().map((item) -> ItemMapper.mapToItemDto(item))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto updateItem(Long itemId, ItemDto updatedItem) {

        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity());

        Item updatedItemObj = itemRepository.save(item);


        return ItemMapper.mapToItemDto(updatedItemObj);
    }

    @Override
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item is not exists with given id : " + itemId));

        itemRepository.deleteById(itemId);
    }

    @Override
    public ItemDto buyItem(Long itemId, ItemDto updatedItem) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item is not exists with given id: " + itemId)
        );

        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());
        item.setPrice(updatedItem.getPrice());
        item.setQuantity(updatedItem.getQuantity()-1);

        Item updatedItemObj = itemRepository.save(item);


        return ItemMapper.mapToItemDto(updatedItemObj);
    }
}
