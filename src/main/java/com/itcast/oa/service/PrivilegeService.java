package com.itcast.oa.service;

import com.itcast.oa.entity.Privilege;

import java.util.List;

public interface PrivilegeService {

	int add(Privilege entity);

	int update(Privilege entity);

	int delete(Integer id);

	Privilege get(Integer id);

	Privilege get(Privilege entity);
	
	List<Privilege> getList(Privilege entity);
	
}
