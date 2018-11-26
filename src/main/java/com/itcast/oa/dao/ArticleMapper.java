package com.itcast.oa.dao;


import com.itcast.oa.entity.Article;

import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface ArticleMapper {
	
	Article selectById(@Param("id") Integer id);


	int deleteById(@Param("id") Integer id);

	int insert(Article entity);

	int insertIfNotnull(Article entity);
	
    int update(Article entity);

	int updateIfNotnull(Article entity);

	List<Article> selectList(@Param("entity") Article entity) ;
	
	

	

}
