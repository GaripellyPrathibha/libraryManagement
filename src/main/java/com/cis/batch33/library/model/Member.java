package com.cis.batch33.library.model;

public class Member {

    private long memberId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    public Member()
    {

    }

    public Member(long memberId,String firstName,String lastName,String emailAddress,String phoneNumber) {

        this.memberId = memberId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailAddress=emailAddress;
        this.phoneNumber=phoneNumber;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
