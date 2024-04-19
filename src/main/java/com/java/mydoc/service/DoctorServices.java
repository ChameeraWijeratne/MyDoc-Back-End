package com.java.mydoc.service;

import com.java.mydoc.entity.Doctor;
import com.java.mydoc.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepo repo;
    public void saveorUpdate(Doctor doctors) {
        repo.save(doctors);
    }

    public Iterable<Doctor> listAllDocs() {
        return this.repo.findAll();
    }

    public void deleteDoctor(String id) {
        repo.deleteById(id);
    }

    public Doctor getUserById(String doctorId) {
        return repo.findById(doctorId).get();
    }

    public List<Doctor>  findAllByEmail(String email) {
        // Find doctor by email
        List<Doctor> doctors = repo.findAllByEmail(email);
        if (doctors == null) {
            // Doctor not found
            return null;
        }
        // Authentication successful
        return doctors;
    }
}
