package com.java.mydoc.repository;

import com.java.mydoc.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DoctorRepo extends MongoRepository<Doctor, String> {
}
