package com.itcast.oa.dto;

import com.itcast.oa.entity.Privilege;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PrivilegeDto implements java.io.Serializable{
	
	//columns START
	/*id*/
	private Integer id;
	/*url*/
	private String url;
	/*权限名称*/
	private String name;
	//columns END

	public PrivilegeDto(){
	}

	public PrivilegeDto(
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
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
			.append("Id",getId())
			.append("Url",getUrl())
			.append("Name",getName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Privilege == false) return false;
		if(this == obj) return true;
		Privilege other = (Privilege)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

