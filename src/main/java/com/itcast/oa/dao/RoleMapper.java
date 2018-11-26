package com.itcast.oa.dao;


import com.itcast.oa.entity.Role;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface RoleMapper {
	
	Role selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(Role entity);

	int insertIfNotnull(Role entity);
	
    int update(Role entity);

	int updateIfNotnull(Role entity);

	List<Role> selectList(@Param("entity") Role entity) ;
	
	

	

}
