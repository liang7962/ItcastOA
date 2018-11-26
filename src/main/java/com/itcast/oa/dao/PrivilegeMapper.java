package com.itcast.oa.dao;


import com.itcast.oa.entity.Privilege;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface PrivilegeMapper {
	
	Privilege selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(Privilege entity);

	int insertIfNotnull(Privilege entity);
	
    int update(Privilege entity);

	int updateIfNotnull(Privilege entity);

	List<Privilege> selectList(@Param("entity") Privilege entity) ;
	
	

	

}
