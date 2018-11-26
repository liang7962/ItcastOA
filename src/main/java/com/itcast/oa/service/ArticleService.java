package com.itcast.oa.service;

import com.itcast.oa.entity.Article;

import java.util.List;

public interface ArticleService {

	int add(Article entity);

	int update(Article entity);

	int delete(Integer id);

	Article get(Integer id);

	Article get(Article entity);
	
	List<Article> getList(Article entity);
	

}
