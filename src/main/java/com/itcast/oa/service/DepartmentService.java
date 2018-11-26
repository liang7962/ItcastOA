package com.itcast.oa.service;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.entity.Department;

import java.util.List;

public interface DepartmentService {

	int add(Department entity);

	int update(Department entity);

	int delete(Integer id);

	Department get(Integer id);

	Department get(Department entity);
	
	List<Department> getList(Department entity);
	

}
