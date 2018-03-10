package mpserver.mapper.microprogram;

import java.util.List;

import mpserver.entity.microprogram.SignActivityEntity;
import mpserver.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/** 
* @author siwei E-mail: siwei666@163.com
* @version 创建时间：2018年3月7日 下午8:01:25 
* 类说明 
*/
public interface SignActivityMapper extends BaseMapper<SignActivityEntity>{

	@Select("SELECT id,creator,modifier,gmt_create,gmt_modified,open_id,activity_name,remark FROM sign_activity")
    @Results({
//        @Result(property = "phone",  column = "phone", javaType = UserSexEnum.class),
        @Result(property = "gmtCreate", column = "gmt_create"),
        @Result(property = "gmtModified", column = "gmt_modified"),
        @Result(property = "openId", column = "open_id"),
        @Result(property = "activityName", column = "activity_name")
    })
	public List<SignActivityEntity> findByOpenId(String openId);
}
