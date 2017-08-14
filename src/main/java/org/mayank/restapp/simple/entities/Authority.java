/**
 * 
 */
package org.mayank.restapp.simple.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name = "authorities")
public class Authority {

	@Id
	@Column(name = "role_id")
	private long role_id;

	@Column(name = "role_name")
	private String role_name;
	
	/**
	 * @return the role_id
	 */
	public long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id
	 *            the role_id to set
	 */
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name
	 *            the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
