package com.niit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
	@Table(name="User")
	public class User  {
		@Id
		private String id;
		@Column(name="name")
		private String name;
		@Column(name="password")
		private String password;
		@Column(name="role")
		private String role;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Integer getMobile() {
			return mobile;
		}
		public void setMobile(Integer mobile) {
			this.mobile = mobile;
		}
		@Column(name="mobile")
		private Integer mobile;
	
	public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}

