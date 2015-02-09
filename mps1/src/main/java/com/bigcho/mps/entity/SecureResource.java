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

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name="tbl_secure_resource")
public class SecureResource {

	@Id
	@Column
	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String resourceId;
	
	@Column
	private String name;
	
	@Column
	private String pattern;
	
	@Column
	private String type;
	
	@Column
	private int sortOrder;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_secure_resource_authority", 
	           joinColumns = { @JoinColumn(name = "resourceId") }, 
	           inverseJoinColumns = { @JoinColumn(name = "authorityCode") })
	private Collection<Authority> authorities;
	
	public void addAuthority(Authority authority) {
		if(this.authorities == null) {
			this.authorities = new ArrayList<Authority>();
		}
		this.authorities.add(authority);
	}
	
}
