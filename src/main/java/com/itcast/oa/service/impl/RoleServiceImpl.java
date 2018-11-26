package com.itcast.oa.service.impl;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.util.DateUtil;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import com.itcast.oa.service.RoleService;
import com.itcast.oa.dao.RoleMapper;
import com.itcast.oa.entity.Role;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class RoleServiceImpl implements RoleService {
	
	private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleMapper roleMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Role entity) {
		Assert.notNull(entity);
		int num = roleMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Role entity) {
		Assert.notNull(entity);
		return roleMapper.updateIfNotnull(entity);
	}

	@Override
	public Role get(Integer id) {
		Role entity =  roleMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return roleMapper.deleteById(id);
	}

	@Override
	public Role get(Role entity) {
		List<Role> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Role> getList(Role entity) {
		Assert.notNull(entity);
		List<Role> entitys = roleMapper.selectList(entity);
		
		return entitys;
	}
	

	
}
