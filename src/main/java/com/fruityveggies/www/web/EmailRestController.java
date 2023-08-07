package com.fruityveggies.www.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fruityveggies.www.email.dto.EmailConfirmDto;
import com.fruityveggies.www.email.dto.EmailVerifyDto;
import com.fruityveggies.www.service.EmailService;
import com.fruityveggies.www.service.EmailServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailRestController {
    
    @Autowired
	private EmailService emailService;
	private EmailServiceImpl emailServiceImpl;
	
	
	@PostMapping("/verify")
	public ResponseEntity<EmailVerifyDto> emailVerify(@RequestBody EmailVerifyDto dto) throws Exception {

		log.info("dto={}", dto);
		
	  String confirm = emailService.sendSimpleMessage(dto.getEmail());
	  log.info("confirm={}", confirm);
	  log.info("emailServiceImpl.ePw={}",emailServiceImpl.ePw);

	  return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/confirm")
	public ResponseEntity<EmailConfirmDto> emailConfirm(@RequestBody EmailConfirmDto dto) throws Exception {

	  log.info("dto={}", dto);	  

	  log.info("emailServiceImpl.ePw={}",emailServiceImpl.ePw);
	  
	  if (dto.getVerificationCode().equals(emailServiceImpl.ePw))
		  dto.setConfirmMessage("success");
	  
	  if (!dto.getVerificationCode().equals(emailServiceImpl.ePw)) {
		  dto.setConfirmMessage("fail");
	  }	
	  
	  return ResponseEntity.ok(dto);
	}
	
	
}
