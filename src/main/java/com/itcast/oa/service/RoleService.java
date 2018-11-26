package com.itcast.oa.service;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.entity.Role;

import java.util.List;

public interface RoleService {

	int add(Role entity);

	int update(Role entity);

	int delete(Integer id);

	Role get(Integer id);

	Role get(Role entity);
	
	List<Role> getList(Role entity);
	

}
