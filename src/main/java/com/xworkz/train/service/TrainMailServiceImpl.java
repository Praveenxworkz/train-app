package com.xworkz.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworkz.train.dto.TrainMailDTO;

@Component
public class TrainMailServiceImpl implements TrainMailService {
	
	@Autowired
	private JavaMailSender mailSender ;

	public TrainMailServiceImpl() {
       System.out.println("TrainMailServiceImpl is created");
	}


	@Override
	public boolean validTrainMail(TrainMailDTO trainMailDTO) {
           boolean flag = false;
           System.out.println("invoked validTrainMail");
           
           if(trainMailDTO.getToEmail() != null && !trainMailDTO.getToEmail().isEmpty() && !trainMailDTO.getToEmail().isBlank()) {
        	   flag = true ;
        	   System.out.println("email is valid :" + trainMailDTO.getToEmail());
           }
           else {
        	   flag = false ;
        	   System.out.println("email is not valid");
        	   return flag ;
           }
           
           if(trainMailDTO.getSubject() != null && !trainMailDTO.getSubject().isEmpty() && !trainMailDTO.getSubject().isBlank()) {
        	   flag = true ;
        	   System.out.println("subject is valid :" + trainMailDTO.getSubject());
           }
           else {
        	   flag = false ;
        	   System.out.println("subject is invalid");
        	   return flag ;
           }
           
           if(trainMailDTO.getBodyText() != null && !trainMailDTO.getBodyText().isEmpty() && !trainMailDTO.getBodyText().isBlank()) {
        	   flag = true ;
        	   System.out.println("BodyText is valid :" + trainMailDTO.getBodyText());
           }
           else {
        	   flag = false ;
        	   System.out.println("bodyText is invalid");
        	   return flag ;
           }	
		return flag;
	}
    
	
	@Override
	public boolean sendMail(TrainMailDTO trainMailDTO) {
         boolean flag = false ;
         try {
        	 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        	 simpleMailMessage.setTo(trainMailDTO.getToEmail());
        	 simpleMailMessage.setFrom("praveenpawar07@outlook.com");
        	 simpleMailMessage.setSubject(trainMailDTO.getSubject());
        	 simpleMailMessage.setText(trainMailDTO.getBodyText());
        	 
        	 this.mailSender.send(simpleMailMessage);
        	 flag = true ;
        	 return flag ;
         }catch(Exception e) {
        	 e.printStackTrace();
         }
		return flag ;
	}	
	
}
