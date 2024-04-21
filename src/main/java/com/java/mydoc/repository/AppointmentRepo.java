package com.java.mydoc.repository;

import com.java.mydoc.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepo extends MongoRepository<Appointment, String> {
    List<Appointment> findByUserId(String userId);

    List<Appointment> findByDocId(String docId);

    List<Appointment> findByDocIdAndAppointmentDateAndAppointmentTime(String docId,String appointmentDate, String appointmentTime);
}
