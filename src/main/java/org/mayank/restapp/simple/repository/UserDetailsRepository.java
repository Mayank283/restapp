package org.mayank.restapp.simple.repository;

import org.mayank.restapp.simple.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsRepository extends JpaRepository<User, Long> {

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	User findByUsername(String username);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	User save(User userEntity);
}