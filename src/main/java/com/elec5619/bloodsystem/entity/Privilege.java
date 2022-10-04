package com.elec5619.bloodsystem.entity;


import javax.persistence.*;
import java.util.Collection;

/**
 * The type Privilege.
 */
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;


    /**
     * Instantiates a new Privilege.
     */
    public Privilege() {
    }


    /**
     * Instantiates a new Privilege.
     *
     * @param name the name
     */
    public Privilege(String name){
        this.name = name;
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
     * Gets roles.
     *
     * @return the roles
     */
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}