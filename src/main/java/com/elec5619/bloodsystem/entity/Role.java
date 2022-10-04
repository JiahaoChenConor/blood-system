package com.elec5619.bloodsystem.entity;

import com.elec5619.bloodsystem.entity.Account;
import com.elec5619.bloodsystem.entity.Privilege;

import javax.persistence.*;
import java.util.Collection;


/**
 * The type Role.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Account> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;


    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Collection<Account> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Collection<Account> users) {
        this.users = users;
    }

    /**
     * Gets privileges.
     *
     * @return the privileges
     */
    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    /**
     * Sets privileges.
     *
     * @param privileges the privileges
     */
    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
