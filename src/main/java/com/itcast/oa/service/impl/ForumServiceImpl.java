package com.itcast.oa.service.impl;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.util.DateUtil;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import com.itcast.oa.service.ForumService;
import com.itcast.oa.dao.ForumMapper;
import com.itcast.oa.entity.Forum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class ForumServiceImpl implements ForumService {
	
	private static Logger logger = LoggerFactory.getLogger(ForumServiceImpl.class);
	@Autowired
	private ForumMapper forumMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Forum entity) {
		Assert.notNull(entity);
		int num = forumMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Forum entity) {
		Assert.notNull(entity);
		return forumMapper.updateIfNotnull(entity);
	}

	@Override
	public Forum get(Integer id) {
		Forum entity =  forumMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return forumMapper.deleteById(id);
	}

	@Override
	public Forum get(Forum entity) {
		List<Forum> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Forum> getList(Forum entity) {
		Assert.notNull(entity);
		List<Forum> entitys = forumMapper.selectList(entity);
		
		return entitys;
	}
	

}
