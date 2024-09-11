package practice.restapi_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
//    @Autowired
//    private ExMapper exMapper;
//
//    @Autowired
//    private ItemRepository itemRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public boolean registerItem(ItemDto itemDto) {

        // Hibernate Session 사용하여 데이터 저장
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

//        itemRepository.save(itemEntity);

        session.save(itemEntity);
        session.getTransaction().commit();
        session.close();

        log.info("service: register...");

        return true;
    }

    public ItemDto getItem(String id) {

        Session session = sessionFactory.openSession();
        ItemEntity itemEntity = session.get(ItemEntity.class, id);
        session.close();

        if(itemEntity == null) {
            return null;
        }
//        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
