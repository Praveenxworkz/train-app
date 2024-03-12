package com.xworkz.train.dto;

public class TrainMailDTO {

	private String toEmail ;
	private String subject ;
	private String bodyText ;
	
	
	public TrainMailDTO() {
       System.out.println(this.getClass().getSimpleName() + "created");
	}


	public TrainMailDTO(String toEmail, String subject, String bodyText) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.bodyText = bodyText;
	}


	public String getToEmail() {
		return toEmail;
	}


	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBodyText() {
		return bodyText;
	}


	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}


	@Override
	public String toString() {
		return "TrainMailDTO [toEmail=" + toEmail + ", subject=" + subject + ", bodyText=" + bodyText + "]";
	}
	
}
