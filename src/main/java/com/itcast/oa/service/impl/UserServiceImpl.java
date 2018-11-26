package com.itcast.oa.service.impl;

import org.springframework.util.Assert;

import com.itcast.oa.service.UserService;
import com.itcast.oa.dao.UserMapper;
import com.itcast.oa.entity.User;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(User entity) {
		Assert.notNull(entity);
		int num = userMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(User entity) {
		Assert.notNull(entity);
		return userMapper.updateIfNotnull(entity);
	}

	@Override
	public User get(Integer id) {
		User entity =  userMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return userMapper.deleteById(id);
	}

	@Override
	public User get(User entity) {
		List<User> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<User> getList(User entity) {
		Assert.notNull(entity);
		List<User> entitys = userMapper.selectList(entity);
		
		return entitys;
	}
	

	
}
