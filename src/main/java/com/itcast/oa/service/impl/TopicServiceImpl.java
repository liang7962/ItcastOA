package com.itcast.oa.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.util.Assert;

import com.github.pagehelper.PageHelper;

import com.itcast.oa.service.TopicService;
import com.itcast.oa.dao.TopicMapper;
import com.itcast.oa.entity.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class TopicServiceImpl implements TopicService {
	
	private static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
	@Autowired
	private TopicMapper topicMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Topic entity) {
		Assert.notNull(entity);
		int num = topicMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Topic entity) {
		Assert.notNull(entity);
		return topicMapper.updateIfNotnull(entity);
	}




	@Override
	public Topic get(Topic entity) {
		List<Topic> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Topic> getList(Topic entity) {
		Assert.notNull(entity);
		List<Topic> entitys = topicMapper.selectList(entity);
		
		return entitys;
	}

}
