/**
 * 
 */
package org.mayank.restapp.simple.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Mayank
 *
 */
@Entity
@Table(name = "user_role")
public class Roles extends BaseEntity {

	@Id
	@SequenceGenerator(name = "rolsq", sequenceName = "role_sq", allocationSize = 1)
	@GeneratedValue(generator = "rolsq")
	@Column(name = "user_role_id")
	private long role_id;

	@Column(name = "user_rolename")
	private String rolename;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private Collection<User> user = new ArrayList<User>();

	/**
	 * @return the role_id
	 */
	public long getRole_id() {
		return role_id;
	}

	/**
	 * @return the role_name
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param role_id
	 *            the role_id to set
	 */
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	/**
	 * @param role_name
	 *            the role_name to set
	 */
	public void setRole_name(String rolename) {
		this.rolename = rolename;
	}
}
