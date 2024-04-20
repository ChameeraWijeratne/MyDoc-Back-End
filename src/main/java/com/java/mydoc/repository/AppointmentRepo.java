package com.java.mydoc.repository;

import com.java.mydoc.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepo extends MongoRepository<Appointment, String> {
    Appointment findByUserId(String userId);
}
