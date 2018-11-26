package com.itcast.oa.service.impl;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.util.DateUtil;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import com.itcast.oa.service.DepartmentService;
import com.itcast.oa.dao.DepartmentMapper;
import com.itcast.oa.entity.Department;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Department entity) {
		Assert.notNull(entity);
		int num = departmentMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Department entity) {
		Assert.notNull(entity);
		return departmentMapper.updateIfNotnull(entity);
	}

	@Override
	public Department get(Integer id) {
		Department entity =  departmentMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return departmentMapper.deleteById(id);
	}

	@Override
	public Department get(Department entity) {
		List<Department> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Department> getList(Department entity) {
		Assert.notNull(entity);
		List<Department> entitys = departmentMapper.selectList(entity);
		
		return entitys;
	}
	

}
