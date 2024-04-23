package com.java.mydoc.controller;

import com.java.mydoc.entity.ConfirmMail;
import com.java.mydoc.service.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailServices emailService;

    @PostMapping("/sendAppConfirmEmail")
    public ResponseEntity<String> sendAppointmentEmail(@RequestBody ConfirmMail request) {
        emailService.sendAppointmentConfirmation(request.getTo(), request.getDocFname(), request.getDocLname(),request.getAppNo(),request.getAppDate(),request.getAppTime(),request.getAppDesc());
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @PostMapping("/sendApprovalEmail")
    public ResponseEntity<String> sendApprovalEmail(@RequestBody ConfirmMail request) {
        emailService.sendAppointmentApproval(request.getTo(), request.getDocFname(), request.getDocLname(),request.getAppDesc());
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }
}
