package practice.restapi_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.restapi_ex.dto.ItemDto;
import practice.restapi_ex.entity.ItemEntity;
import practice.restapi_ex.mapper.ExMapper;
import practice.restapi_ex.repository.ItemRepository;

import java.util.HashMap;

@Service
@Slf4j
public class RestExService {
    @Autowired
    private ExMapper exMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
        //DB insert
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("id",itemDto.getId());
//        map.put("name",itemDto.getName());
//
//        exMapper.registerItem(map);
        //exMapper.registerItem(itemDto);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        log.info("service: register...");

        //DB insert 가 성공했을 경우 true
        return true;
    }

    public ItemDto getItem(String id) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//
//        HashMap<String,Object> res = exMapper.findById(paramMap);

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
