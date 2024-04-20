package com.java.mydoc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointment")
public class Appointment {
    @Id
    private String _id;
    private String docId;
    private String userId;
    private String patientName;
    private String appointmentDate;
    private String appointmentTime;
    private String description;
    private Number rating;

    public Appointment(String _id, String docId, String userId, String patientName, String appointmentDate, String appointmentTime, String description, Number rating) {
        this._id = _id;
        this.docId = docId;
        this.userId = userId;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.description = description;
        this.rating = rating;
    }

    public Appointment() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getRating() {
        return rating;
    }

    public void setRating(Number rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "_id='" + _id + '\'' +
                ", docId='" + docId + '\'' +
                ", userId='" + userId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}


