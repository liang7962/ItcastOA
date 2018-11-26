package com.itcast.oa.service.impl;

import org.springframework.util.Assert;


import com.itcast.oa.service.ArticleService;
import com.itcast.oa.dao.ArticleMapper;
import com.itcast.oa.entity.Article;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service
public class ArticleServiceImpl implements ArticleService {
	
	private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int add(Article entity) {
		Assert.notNull(entity);
		int num = articleMapper.insertIfNotnull(entity);
		return num;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int update(Article entity) {
		Assert.notNull(entity);
		return articleMapper.updateIfNotnull(entity);
	}

	@Override
	public Article get(Integer id) {
		Article entity =  articleMapper.selectById(id);
		return entity;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int delete(Integer id) {
		return articleMapper.deleteById(id);
	}

	@Override
	public Article get(Article entity) {
		List<Article> entitys = getList(entity);

		return !entitys.isEmpty() ? entitys.get(0) : null;
	}
	
	/**
	 * 查询所有数据
	 * @param entity 请求参数
	 * @return
	 */
	@Override
	public List<Article> getList(Article entity) {
		Assert.notNull(entity);
		List<Article> entitys = articleMapper.selectList(entity);
		
		return entitys;
	}

}
