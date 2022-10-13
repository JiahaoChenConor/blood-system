package com.elec5619.bloodsystem.dao;

import com.elec5619.bloodsystem.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Privilege repository.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    /**
     * Find by name privilege.
     *
     * @param name the name
     * @return the privilege
     */
    Privilege findByName(String name);
}
