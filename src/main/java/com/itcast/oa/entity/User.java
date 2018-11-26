package com.itcast.oa.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User implements java.io.Serializable{
	
	//columns START
	/*id*/
	private Integer id;
	/*登录名*/
	private String loginName;
	/*密码*/
	private String password;
	/*真实姓名*/
	private String name;
	/*性别 （1男，2女）*/
	private Integer gander;
	/*电话号码*/
	private String phoneNumber;
	/*电子邮箱*/
	private String email;
	/*说明*/
	private String description;
	//columns END

	public User(){
	}

	public User(
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
	public void setLoginName(String value) {
		this.loginName = value;
	}
	
	public String getLoginName() {
		return this.loginName;
	}
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setGander(Integer value) {
		this.gander = value;
	}
	
	public Integer getGander() {
		return this.gander;
	}
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}


	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.DEFAULT_STYLE)
			.append("Id",getId())
			.append("LoginName",getLoginName())
			.append("Password",getPassword())
			.append("Name",getName())
			.append("Gander",getGander())
			.append("PhoneNumber",getPhoneNumber())
			.append("Email",getEmail())
			.append("Description",getDescription())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

