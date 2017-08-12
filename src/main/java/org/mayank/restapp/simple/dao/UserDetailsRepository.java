package org.mayank.restapp.simple.dao;

import org.mayank.restapp.simple.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailsRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM user_detail where username = :username", nativeQuery = true)
	UserEntity findByUsername(@Param("username") String username);
}
