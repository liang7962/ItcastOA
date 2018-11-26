package com.itcast.oa.dto;

import com.itcast.oa.entity.Forum;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ForumDto implements java.io.Serializable{
	
	//columns START
	/*id*/
	private Integer id;
	/*name*/
	private String name;
	/*description*/
	private String description;
	/*排序用的位置号*/
	private String position;
	/*主题数量*/
	private Integer topicCount;
	/*文章数量（主题+回复）*/
	private Integer articleCount;
	//columns END

	public ForumDto(){
	}

	public ForumDto(
		Integer id
	){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setPosition(String value) {
		this.position = value;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setTopicCount(Integer value) {
		this.topicCount = value;
	}
	
	public Integer getTopicCount() {
		return this.topicCount;
	}
	public void setArticleCount(Integer value) {
		this.articleCount = value;
	}
	
	public Integer getArticleCount() {
		return this.articleCount;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Description",getDescription())
			.append("Position",getPosition())
			.append("TopicCount",getTopicCount())
			.append("ArticleCount",getArticleCount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Forum == false) return false;
		if(this == obj) return true;
		Forum other = (Forum)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

