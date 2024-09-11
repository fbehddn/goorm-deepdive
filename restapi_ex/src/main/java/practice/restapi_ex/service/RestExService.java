package practice.restapi_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.restapi_ex.dto.ItemDto;
import practice.restapi_ex.entity.ItemEntity;
import practice.restapi_ex.repository.ItemRepository;


@Service
@Slf4j
public class RestExService {
    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        log.info("service: register...");

        return true;
    }

    public ItemDto getItem(String id) {
        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
