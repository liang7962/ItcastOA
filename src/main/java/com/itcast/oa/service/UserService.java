package com.itcast.oa.service;

import com.itcast.oa.entity.User;

import java.util.List;

public interface UserService {

	int add(User entity);

	int update(User entity);

	int delete(Integer id);

	User get(Integer id);

	User get(User entity);
	
	List<User> getList(User entity);
	

}
