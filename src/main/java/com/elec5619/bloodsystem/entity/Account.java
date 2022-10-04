package com.elec5619.bloodsystem.entity;


import org.w3c.dom.ls.LSInput;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


/**
 * The type Account.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email", unique=true)
    private String email;
    private String password;

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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
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

    /**
     * Gets health info.
     *
     * @return the health info
     */
    public HealthInfo getHealthInfo() {
        return healthInfo;
    }

    /**
     * Sets health info.
     *
     * @param healthInfo the health info
     */
    public void setHealthInfo(HealthInfo healthInfo) {
        this.healthInfo = healthInfo;
    }

    /**
     * Gets profile.
     *
     * @return the profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Sets profile.
     *
     * @param profile the profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets history records.
     *
     * @return the history records
     */
    public List<HistoryRecord> getHistoryRecords() {
        return historyRecords;
    }

    /**
     * Sets history records.
     *
     * @param historyRecords the history records
     */
    public void setHistoryRecords(List<HistoryRecord> historyRecords) {
        this.historyRecords = historyRecords;
    }

    /**
     * Gets message records.
     *
     * @return the message records
     */
    public List<MessageRecord> getMessageRecords() {
        return messageRecords;
    }

    /**
     * Sets message records.
     *
     * @param messageRecords the message records
     */
    public void setMessageRecords(List<MessageRecord> messageRecords) {
        this.messageRecords = messageRecords;
    }


    @Enumerated(EnumType.STRING)
    private Provider provider;

    /**
     * Gets provider.
     *
     * @return the provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * Sets provider.
     *
     * @param provider the provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}