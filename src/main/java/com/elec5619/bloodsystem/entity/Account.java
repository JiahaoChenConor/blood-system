package com.elec5619.bloodsystem.entity;


import org.w3c.dom.ls.LSInput;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email", unique=true)
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;




    @OneToOne
    @JoinColumn(name = "healthInfoId")
    private HealthInfo healthInfo;

    @OneToOne
    @JoinColumn(name = "profileId")
    private Profile profile;


    @OneToMany(mappedBy = "account")
    private List<HistoryRecord> historyRecords;

    @OneToMany(mappedBy = "account")
    private List<MessageRecord> messageRecords;



}