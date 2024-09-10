package practice.restapi_ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface ExMapper {
    public HashMap<String, Object> findById(HashMap<String, Object> paramMap);
}
