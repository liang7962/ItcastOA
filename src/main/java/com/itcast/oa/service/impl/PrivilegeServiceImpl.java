package com.itcast.oa.service.impl;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.util.DateUtil;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import com.itcast.oa.service.PrivilegeService;
import com.itcast.oa.dao.PrivilegeMapper;
import com.itcast.oa.entity.Privilege;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	private static Logger logger = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

	@Autowired
	private PrivilegeMapper privilegeMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Privilege entity) {
		Assert.notNull(entity);
		int num = privilegeMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Privilege entity) {
		Assert.notNull(entity);
		return privilegeMapper.updateIfNotnull(entity);
	}

	@Override
	public Privilege get(Integer id) {
		Privilege entity =  privilegeMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return privilegeMapper.deleteById(id);
	}

	@Override
	public Privilege get(Privilege entity) {
		List<Privilege> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Privilege> getList(Privilege entity) {
		Assert.notNull(entity);
		List<Privilege> entitys = privilegeMapper.selectList(entity);
		
		return entitys;
	}
	

}
