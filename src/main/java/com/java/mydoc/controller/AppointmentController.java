package com.java.mydoc.controller;

import com.java.mydoc.entity.Appointment;
import com.java.mydoc.service.AppointmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping(value = "/save")
    private String saveAppointment(@RequestBody Appointment appointments){
        appointmentServices.saveorUpdate(appointments);
        return appointments.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Appointment> getAppointments(){
        return appointmentServices.listAllAppointments();
    }

    @PutMapping(value = "/edit/{id}")
    private Appointment update(@RequestBody Appointment appointment,@PathVariable(name="id")String _id){
        appointment.set_id(_id);
        appointmentServices.saveorUpdate(appointment);
        return appointment;
    }

    @DeleteMapping(value = "/delete/{id}")
    private void deleteAppontment(@PathVariable("id")String _id){
        appointmentServices.deleteAppointment(_id);
    }

    @RequestMapping(value = "/search/{id}")
    private Appointment getAppontment(@PathVariable(name="id")String appointmentId){

        return appointmentServices.getAppointmentById(appointmentId);
    }

    @RequestMapping(value = "/searchUser/{userId}")
    private List<Appointment> getUsers(@PathVariable(name="userId")String userId){

        return appointmentServices.getAppointmentByUserId(userId);
    }

    @PutMapping(value = "/editRating/{id}")
    public ResponseEntity<String> updateAppointmentRating(@PathVariable("id") String id,
                                                                @RequestBody int rating) {
        try {
            Appointment appointment = appointmentServices.getAppointmentById(id);

            appointment.setRating(rating); // Assuming isActive is a boolean field
            appointmentServices.saveorUpdate(appointment);

            // Return a success response
            return ResponseEntity.ok("Appointment rating updated successfully");
        } catch (Exception e) {
            // Return an error response if something goes wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update appointment rating");
        }
    }

    @GetMapping("/averageRating/{docId}")
    public ResponseEntity<Double> calculateAverageRatingByDocId(@PathVariable("docId") String docId) {
        try {
            double averageRating = appointmentServices.calculateAverageRatingByDocId(docId);
            return ResponseEntity.ok(averageRating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/getIndex")
    public ResponseEntity<Integer> getAppointmentIndex(
            @RequestParam("Id") String Id,
            @RequestParam("docId") String docId,
            @RequestParam("userId") String userId,
            @RequestParam("appointmentDate") String appointmentDate,
            @RequestParam("appointmentTime") String appointmentTime) {
        try {
            List<Appointment> appointments = appointmentServices.getAppointmentByDocIdAndDateTime(docId, appointmentDate, appointmentTime);

            // Iterate through the list of appointments
            for (int i = 0; i < appointments.size(); i++) {
                Appointment appointment = appointments.get(i);
                // Check if the appointment matches the provided criteria
                if (appointment.getUserId().equals(userId) && appointment.get_id().equals(Id)
                        && appointment.getAppointmentDate().equals(appointmentDate)
                        && appointment.getAppointmentTime().equals(appointmentTime)) {
                    // Return the index of the matching appointment
                    return ResponseEntity.ok(i+1);
                }
            }
            // If no matching appointment found, return not found status
            return ResponseEntity.ok(0);
        } catch (Exception e) {
            // Return an error response if something goes wrong
            return ResponseEntity.ok(-1);
        }
    }
}
