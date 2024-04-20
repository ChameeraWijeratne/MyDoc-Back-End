package com.java.mydoc.repository;

import com.java.mydoc.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface DoctorRepo extends MongoRepository<Doctor, String> {
    List<Doctor> findAllByEmail(String email);

    Doctor findByEmail(String email);
}
