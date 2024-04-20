package com.java.mydoc.controller;

import com.java.mydoc.entity.Appointment;
import com.java.mydoc.service.AppointmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    private Appointment getUsers(@PathVariable(name="userId")String userId){

        return appointmentServices.getAppointmentByUserId(userId);
    }
}
