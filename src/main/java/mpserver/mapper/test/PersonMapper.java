package mpserver.mapper.test;

import java.util.List;

import mpserver.entity.test.PersonEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper extends mpserver.mapper.BaseMapper<PersonEntity>{

    @Select("SELECT id,name,gender,birthday,phone,address FROM person")
    @Results({
//        @Result(property = "phone",  column = "phone", javaType = UserSexEnum.class),
        @Result(property = "address", column = "address")
    })
    List<PersonEntity> findAll();
}
