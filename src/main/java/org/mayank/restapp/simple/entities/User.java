package org.mayank.restapp.simple.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail")
public class User extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@SequenceGenerator(name = "usrdtlsq", sequenceName = "user_detail_sq", allocationSize = 1)
	@GeneratedValue(generator = "usrdtlsq")
	private long user_id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "enable")
	private String enable;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "middlename")
	private String middlename;

	@Column(name = "lastname")
	private String lastname;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_USER_ROLE", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_role_id"))
	private Collection<Roles> roles = new ArrayList<Roles>();

	public User() {

	}

	/**
	 * @param user_id
	 * @param username
	 * @param email
	 * @param password
	 * @param enable
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 */
	public User(String username, String email, String password, String enable, String firstname, String middlename,
			String lastname) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enable = enable;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the enable
	 */
	public String getEnable() {
		return enable;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the roles
	 */
	public Collection<Roles> getRoles() {
		return roles;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	public Boolean isEnable() {
		return Boolean.parseBoolean(enable);
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param middlename
	 *            the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
