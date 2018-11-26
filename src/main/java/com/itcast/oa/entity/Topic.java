package com.itcast.oa.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Topic implements java.io.Serializable{
	
	//columns START
	/*type*/
	private String type;
	/*replyCount*/
	private Integer replyCount;
	/*最后更新时间（主题发表时间或最后回复的时间）*/
	private java.util.Date lastUpdateTime;
	private java.util.Date lastUpdateTimeBegin;
	private java.util.Date lastUpdateTimeEnd;
	//columns END

	public Topic(){
	}



	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
	}
	public void setReplyCount(Integer value) {
		this.replyCount = value;
	}
	
	public Integer getReplyCount() {
		return this.replyCount;
	}
	
	public void setLastUpdateTimeBegin(java.util.Date value) {
		this.lastUpdateTimeBegin = value;
	}
	
	public java.util.Date getLastUpdateTimeBegin() {
		return this.lastUpdateTimeBegin;
	}

	public void setLastUpdateTimeEnd(java.util.Date value) {
		this.lastUpdateTimeEnd = value;
	}
	
	public java.util.Date getLastUpdateTimeEnd() {
		return this.lastUpdateTimeEnd;
	}

	public void setLastUpdateTime(java.util.Date value) {
		this.lastUpdateTime = value;
	}
	
	public java.util.Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
			.append("Type",getType())
			.append("ReplyCount",getReplyCount())
			.append("LastUpdateTime",getLastUpdateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Topic == false) return false;
		if(this == obj) return true;
		Topic other = (Topic)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

