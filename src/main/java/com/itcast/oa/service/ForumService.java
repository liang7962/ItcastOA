package com.itcast.oa.service;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.entity.Forum;

import java.util.List;

public interface ForumService {

	int add(Forum entity);

	int update(Forum entity);

	int delete(Integer id);

	Forum get(Integer id);

	Forum get(Forum entity);
	
	List<Forum> getList(Forum entity);
	

}
