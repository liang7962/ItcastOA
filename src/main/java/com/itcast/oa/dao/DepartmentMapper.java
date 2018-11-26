package com.itcast.oa.dao;


import com.itcast.oa.entity.Department;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface DepartmentMapper {
	
	Department selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(Department entity);

	int insertIfNotnull(Department entity);
	
    int update(Department entity);

	int updateIfNotnull(Department entity);

	List<Department> selectList(@Param("entity") Department entity) ;
	
	

	

}
