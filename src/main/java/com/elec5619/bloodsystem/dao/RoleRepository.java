package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Role repository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * Find by name role.
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);
}
