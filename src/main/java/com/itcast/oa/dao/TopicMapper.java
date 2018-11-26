package com.itcast.oa.dao;


import com.itcast.oa.entity.Topic;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface TopicMapper {
	



	int insert(Topic entity);

	int insertIfNotnull(Topic entity);
	
    int update(Topic entity);

	int updateIfNotnull(Topic entity);

	List<Topic> selectList(@Param("entity") Topic entity) ;
	
	

	

}
