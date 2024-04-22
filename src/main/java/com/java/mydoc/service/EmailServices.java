package com.java.mydoc.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAppointmentConfirmation(String to, String docFname, String docLname, String appNo, String appDate, String appTime, String appDesc) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            helper.setTo(to);
            helper.setSubject("Appointment Confirmation");
            helper.setText("Your appointment (No: " + appNo + ") has been successfully registered.\n\nDoctor Name : Dr. " + docFname+" "+docLname+"\nAppointment Number: " + appNo+"\nAppointment Date:" + appDate+"\nAppointment Time:" + appTime+"\nAppointment Description:" + appDesc);
            javaMailSender.send(mimeMessage);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
