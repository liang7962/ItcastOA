package com.itcast.oa.dao;


import com.itcast.oa.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	
	User selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(User entity);

	int insertIfNotnull(User entity);
	
    int update(User entity);

	int updateIfNotnull(User entity);

	List<User> selectList(@Param("entity") User entity) ;
	
	

	

}
