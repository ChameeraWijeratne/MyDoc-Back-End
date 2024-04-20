package com.java.mydoc.service;

import com.java.mydoc.entity.Appointment;
import com.java.mydoc.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Appointment getAppointmentByUserId(String userId) {
        return repo.findByUserId(userId);
    }

}
