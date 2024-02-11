package com.java.mydoc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctor")
public class Doctor {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String nicNumber;
    private String gender;
    private String birthday;
    private String profilePic;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private Number postalCode;
    private String email;
    private Number contactNumber;
    private String mbbsId;
    private String mbbsCertificate;
    private String doctorCategory;
    private String password;
    private Boolean isActivate;

    public Doctor(String _id, String firstName, String lastName, String nicNumber, String gender, String birthday, String profilePic, String addressLine1, String addressLine2, String city, Number postalCode, String email, Number contactNumber, String mbbsId, String mbbsCertificate, String doctorCategory, String password, Boolean isActivate) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nicNumber = nicNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.profilePic = profilePic;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.contactNumber = contactNumber;
        this.mbbsId = mbbsId;
        this.mbbsCertificate = mbbsCertificate;
        this.doctorCategory = doctorCategory;
        this.password = password;
        this.isActivate = isActivate;
    }

    public Doctor() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Number getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Number postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Number contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMbbsId() {
        return mbbsId;
    }

    public void setMbbsId(String mbbsId) {
        this.mbbsId = mbbsId;
    }

    public String getMbbsCertificate() {
        return mbbsCertificate;
    }

    public void setMbbsCertificate(String mbbsCertificate) {
        this.mbbsCertificate = mbbsCertificate;
    }

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "_id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nicNumber='" + nicNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", mbbsId='" + mbbsId + '\'' +
                ", mbbsCertificate='" + mbbsCertificate + '\'' +
                ", doctorCategory='" + doctorCategory + '\'' +
                ", password='" + password + '\'' +
                ", isActivate=" + isActivate +
                '}';
    }
}
