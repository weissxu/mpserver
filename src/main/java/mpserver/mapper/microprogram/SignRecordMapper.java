package mpserver.mapper.microprogram;

import java.util.List;

import mpserver.entity.microprogram.SignRecordEntity;
import mpserver.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/** 
* @author siwei E-mail: siwei666@163.com
* @version 创建时间：2018年3月7日 下午8:01:25 
* 类说明 
*/
public interface SignRecordMapper extends BaseMapper<SignRecordEntity>{

	@Select("SELECT id,creator,modifier,gmt_create,gmt_modified,open_id,activity_id,activity_name,remark FROM sign_record")
	public List<SignRecordEntity> findByOpenId(String openId);
}
