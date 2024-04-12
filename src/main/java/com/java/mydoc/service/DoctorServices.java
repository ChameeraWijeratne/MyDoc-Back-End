package com.java.mydoc.service;

import com.java.mydoc.entity.Doctor;
import com.java.mydoc.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
