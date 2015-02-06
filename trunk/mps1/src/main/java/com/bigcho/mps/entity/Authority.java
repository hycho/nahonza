/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bigcho.mps.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name="tbl_authority")
public class Authority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	public Authority(){}
	public Authority(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	@Id
	@Column
	private String authorityCode;
	
	@Column
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_user_authority", 
	           joinColumns = { @JoinColumn(name = "authorityCode") }, 
	           inverseJoinColumns = { @JoinColumn(name = "userId") })
	private Collection<User> users;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_secure_resource_authority", 
	           joinColumns = { @JoinColumn(name = "authorityCode") }, 
	           inverseJoinColumns = { @JoinColumn(name = "resourceId") })
	private Collection<SecureResource> resources;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_group_authority", 
	           joinColumns = { @JoinColumn(name = "authorityCode") }, 
	           inverseJoinColumns = { @JoinColumn(name = "groupId") })
	private Collection<Group> groups;
	
	@Override
	public String getAuthority() {
		return authorityCode;
	}
}
