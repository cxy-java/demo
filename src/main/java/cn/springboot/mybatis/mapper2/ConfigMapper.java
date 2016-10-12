package cn.springboot.mybatis.mapper2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ConfigMapper {

	@Select({"select * from t_config"})
	public List<Map<String,Object>> qryConfig();
}
