package com.javaReact.javaReactBackend.controller;

import com.javaReact.javaReactBackend.dto.ItemDto;
import com.javaReact.javaReactBackend.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto savedItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long id) {
        ItemDto itemDto = itemService.getItemById(id);
        return ResponseEntity.ok(itemDto);
    }

    @GetMapping()
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long itemId,
                                              @RequestBody ItemDto updatedItem) {
        ItemDto itemDto = itemService.updateItem(itemId, updatedItem);
        return ResponseEntity.ok(itemDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok("Item deleted successfully!");
    }

    @PutMapping(value = "/buy/{id}")
    public ResponseEntity<ItemDto> buyItem(@PathVariable("id") Long itemId,
                                              @RequestBody ItemDto updatedItem) {
        ItemDto itemDto = itemService.buyItem(itemId, updatedItem);
        return ResponseEntity.ok(itemDto);
    }


}
