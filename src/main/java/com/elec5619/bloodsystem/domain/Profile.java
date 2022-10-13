package com.elec5619.bloodsystem.domain;


import javax.persistence.*;

/**
 * The type Profile.
 */
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;

    private String dateOfBirth;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String mobileNum;

    /**
     * Gets profile id.
     *
     * @return the profile id
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * Sets profile id.
     *
     * @param profileId the profile id
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets mobile num.
     *
     * @return the mobile num
     */
    public String getMobileNum() {
        return mobileNum;
    }

    /**
     * Sets mobile num.
     *
     * @param mobileNum the mobile num
     */
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}
