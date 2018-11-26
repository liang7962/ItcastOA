package com.itcast.oa.dao;


import com.itcast.oa.entity.Forum;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface ForumMapper {
	
	Forum selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(Forum entity);

	int insertIfNotnull(Forum entity);
	
    int update(Forum entity);

	int updateIfNotnull(Forum entity);

	List<Forum> selectList(@Param("entity") Forum entity) ;
	
	

	

}
