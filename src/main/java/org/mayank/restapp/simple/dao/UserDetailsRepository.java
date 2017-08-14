package org.mayank.restapp.simple.dao;

import org.mayank.restapp.simple.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsRepository extends JpaRepository<UserEntity, Long> {

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	//@Query(value = "SELECT * FROM user_detail where username = :username", nativeQuery = true)
	UserEntity findByUsername(/*@Param("username")*/ String username);

	/*
	 * @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	 * 
	 * @Query(value =
	 * "SELECT ud.*, auth.role_name FROM user_detail ud JOIN user_authorities ua ON ud.user_id = ua.user_id JOIN authorities auth ON  ua.role_id =auth.role_id WHERE ud.username =:username"
	 * , nativeQuery = true) UserEntity findByUsername(@Param("username") String
	 * username);
	 */
}
