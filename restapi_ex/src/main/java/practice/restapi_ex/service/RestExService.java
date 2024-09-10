package practice.restapi_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.restapi_ex.dto.ItemDto;
import practice.restapi_ex.mapper.ExMapper;

import java.util.HashMap;

@Service
@Slf4j
public class RestExService {
    private final ExMapper exMapper;

    public RestExService(ExMapper exMapper) {
        this.exMapper = exMapper;
    }

    public boolean registerItem(ItemDto itemDto) {
        //DB insert

        log.info("service: register...");

        //DB insert 가 성공했을 경우 true
        return true;
    }

    public ItemDto getItem(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String,Object> res = exMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId(res.get("ID").toString());
        itemDto.setName(res.get("NAME").toString());

        return itemDto;
    }
}
