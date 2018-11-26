package com.itcast.oa.service;

import com.github.pagehelper.PageInfo;
import com.itcast.oa.entity.Topic;

import java.util.List;

public interface TopicService {

	int add(Topic entity);

	int update(Topic entity);



	Topic get(Topic entity);
	
	List<Topic> getList(Topic entity);
	

}
