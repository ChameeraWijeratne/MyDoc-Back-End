package com.java.mydoc.service;

import com.java.mydoc.entity.Appointment;
import com.java.mydoc.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServices {
    @Autowired
    private AppointmentRepo repo;

    public void saveorUpdate(Appointment appointment) {
        repo.save(appointment);
    }

    public Iterable<Appointment> listAllAppointments() {
        return this.repo.findAll();
    }

    public void deleteAppointment(String id) {
        repo.deleteById(id);
    }

    public Appointment getAppointmentById(String appointmentId) {
        return repo.findById(appointmentId).get();
    }

    public List<Appointment> getAppointmentByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    public double calculateAverageRatingByDocId(String docId) {
        List<Appointment> appointments = repo.findByDocId(docId);

        // Calculate the total sum of ratings
        int totalRatings = 0;
        int count = 0;
        for (Appointment appointment : appointments) {
            Number rating = appointment.getRating();
            if(rating.intValue()!=0) {
                totalRatings += rating.intValue();
                count++;
            }
        }

        // Calculate the average rating
        double averageRating = appointments.isEmpty() ? 0 : (double) totalRatings / count;

        return averageRating;
    }

    public List<Appointment> getAppointmentByDocIdAndDateTime(String docId, String appointmentDate, String appointmentTime) {
        return repo.findByDocIdAndAppointmentDateAndAppointmentTime(docId, appointmentDate, appointmentTime);
    }
}
