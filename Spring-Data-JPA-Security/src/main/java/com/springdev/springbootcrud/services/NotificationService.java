package com.springdev.springbootcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springdev.springbootcrud.domains.User;

@Service
public class NotificationService {

	private JavaMailSender mailSender;
	
	@Autowired
	public NotificationService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Async
	public void sendNotification(User user) throws InterruptedException {
		
		System.out.println("Sleeping now...");
		Thread.sleep(10000);
		
		System.out.println("Sending email...");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("rtestdev");
		mail.setTo(user.getEmail());
		mail.setSubject("Registration");
		mail.setText("Registration successfuly");
		mailSender.send(mail);
		
		System.out.println("Email sent!");
	}
}
