package com.itcast.oa.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Article implements java.io.Serializable{
	
	//columns START
	/*id*/
	private Integer id;
	/*标题*/
	private String title;
	/*内容*/
	private String content;
	/*发表时间*/
	private java.util.Date postTime;
	private java.util.Date postTimeBegin;
	private java.util.Date postTimeEnd;
	/*发表文章时所用的IP地址*/
	private String ipAdd;
	//columns END

	public Article(){
	}

	public Article(
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
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setPostTimeBegin(java.util.Date value) {
		this.postTimeBegin = value;
	}
	
	public java.util.Date getPostTimeBegin() {
		return this.postTimeBegin;
	}

	public void setPostTimeEnd(java.util.Date value) {
		this.postTimeEnd = value;
	}
	
	public java.util.Date getPostTimeEnd() {
		return this.postTimeEnd;
	}

	public void setPostTime(java.util.Date value) {
		this.postTime = value;
	}
	
	public java.util.Date getPostTime() {
		return this.postTime;
	}
	public void setIpAdd(String value) {
		this.ipAdd = value;
	}
	
	public String getIpAdd() {
		return this.ipAdd;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
			.append("Id",getId())
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("PostTime",getPostTime())
			.append("IpAdd",getIpAdd())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Article == false) return false;
		if(this == obj) return true;
		Article other = (Article)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

