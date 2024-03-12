package com.xworkz.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.train.dto.TrainMailDTO;
import com.xworkz.train.service.TrainMailService;

@Component
@RequestMapping("/")
public class TrainMailController {

	@Autowired
	private TrainMailService trainMailService ;
	
	public TrainMailController() {
       System.out.println( this.getClass().getSimpleName() + " created");
	}

	@RequestMapping(value = "/getMailResource", method = RequestMethod.GET)
	public String getMailResource() {
		System.out.println("invoked getMailResource()");
		return "/WEB-INF/TrainMail.jsp" ;
	}
	
	
	@RequestMapping(value = "/readMailMessage", method = RequestMethod.POST)
	public String readMailMessage(@ModelAttribute TrainMailDTO trainMailDTO , Model model) {
		System.out.println("invoked readMailMessage()");
		
		boolean isMailValid = this.trainMailService.validTrainMail(trainMailDTO);
		System.out.println("isMailValid");
		if(isMailValid) {
			System.out.println("Email is valid");
			boolean send = this.trainMailService.sendMail(trainMailDTO);
			if(send) {
				model.addAttribute("MailMessage", "Email is sent ");
			}
			else {
				model.addAttribute("MailMessage", "Email is not sent");
			}
		}
		else {
			System.out.println("email is not valid");
		}
		
		return "/WEB-INF/TrainMail.jsp" ;
	}
	
	 
}
