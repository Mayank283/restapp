/**
 * 
 */
package org.mayank.restapp.simple.repository;
import org.mayank.restapp.simple.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mayank
 *
 */
public interface RolesRepository extends JpaRepository<Roles, Long> {

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	Roles findByrolename(String roleName);
}
