package com.fruityveggies.www.service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemOption;
import com.fruityveggies.www.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    public Item findItemById(long id) {
        return itemRepository.findItemById(id);
    }
    
    public List<ItemItemOptionDto> getJoinedItemAndItemOptionByItemId(long id){
        return itemRepository.getJoin(id);
    }
    

}
