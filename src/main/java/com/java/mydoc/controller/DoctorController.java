package com.java.mydoc.controller;

import com.java.mydoc.entity.Doctor;
import com.java.mydoc.service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;




import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/doctor")
public class DoctorController {

    private static final String FILE_STORAGE_DIRECTORY = "C:\\Users\\Chameera\\Downloads";

    @Autowired
    private DoctorServices doctorServices;

    @PostMapping(value = "/save")
    private ResponseEntity<String> saveDoctor(@ModelAttribute Doctor doctors){
        try {
            doctors.setActivate(false);
            // Save the doctor entity with the image path
            doctorServices.saveorUpdate(doctors);

            return new ResponseEntity<>("Doctor created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating doctor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    private GridFsTemplate gridFsTemplate;
    // Utility method to save the image and return the file path
    private String saveImage(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();

            Path targetPath = Paths.get(FILE_STORAGE_DIRECTORY, fileName);
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);

            // Return the file path
            return targetPath.toString();
        }
        return null;
    }

    @GetMapping(value = "/getAll")
    private Iterable<Doctor>getDoctors(){
        return doctorServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Doctor update(@RequestBody Doctor doctor,@PathVariable(name="id")String _id){
        doctor.set_id(_id);
        doctorServices.saveorUpdate(doctor);
        return doctor;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteDoctor(@PathVariable("id")String _id){
        doctorServices.deleteDoctor(_id);
    }

    @RequestMapping(value = "/search/{id}")
    private Doctor getDoctors(@PathVariable(name="id")String doctorId){

        return doctorServices.getUserById(doctorId);
    }
}
