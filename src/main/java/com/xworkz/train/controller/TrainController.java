package com.xworkz.train.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.train.dao.TrainDAO;
import com.xworkz.train.dto.TrainDTO;
import com.xworkz.train.entity.TrainEntity;
import com.xworkz.train.service.TrainServiceImpl;

@Controller
@RequestMapping("/")
public class TrainController { 

	@Autowired
	private TrainServiceImpl trainServiceImpl ;
	
	public TrainController() {
		System.out.println(this.getClass().getSimpleName() +" servlet created");
	}
	
	@RequestMapping("/getWelcomeFile")
	public String getWelcomeFile() {
		System.out.println("invoked getWelcomeFile");
		return "/WEB-INF/welcome.jsp" ;
	}
	
	
	@RequestMapping("/readValues")
	public String readValues(@ModelAttribute TrainDTO trainDTO ,Model model) {
		System.out.println("invoked readValues()");
		System.out.println("train name :" + trainDTO.getTrainName());
		System.out.println("train speed :" + trainDTO.getTrainSpeed());
		System.out.println("train color :" + trainDTO.getTrainColor());
		System.out.println("no of compartments :" + trainDTO.getNoOfCompartments());
		System.out.println("no of wheels :" + trainDTO.getNoOfWheels());
		System.out.println("train type :" + trainDTO.getTrainType());
		
		boolean isUserDataValid = this.trainServiceImpl.validateUserData(trainDTO);
		   if(isUserDataValid) {
			   System.out.println("user data is valid");
			   boolean isUserDataSaved = this.trainServiceImpl.saveAllUserData(trainDTO);
			   if(isUserDataSaved) {
				   System.out.println("user data have been saved in the database");
			   }
			   else {
				   System.out.println("user data not saved in the database");
			   }
		   }
		   else {
			  System.out.println("user data is not valid"); 
			  Map<String, String> mapContainer = TrainServiceImpl.mapContainer ;
			  model.addAttribute("errorTrainName", mapContainer.get("TRAINNAME"));
			  model.addAttribute("errorTrainSpeed" ,mapContainer.get("TRAINSPEED"));
			  model.addAttribute("errorTrainColor" ,mapContainer.get("TRAINCOLOR"));
			  model.addAttribute("errorInCompart" ,mapContainer.get("NOOFCOMPARTMENTS"));
			  model.addAttribute("errorInNumber" ,mapContainer.get("NOOFWHEELS"));
			  model.addAttribute("errorInTrainType" ,mapContainer.get("TRAINTYPE"));
		   }
		return "/WEB-INF/welcome.jsp" ;
	}
	
	
		@RequestMapping(value = "/searchForTrainEntity")
		public String searchForTrainEntity(@RequestParam String trainName , Model model) {
			System.out.println("invoked searchForTrainEntity() trainName : " + trainName);
			
		boolean isTrainNameValid = this.trainServiceImpl.validateTrainName(trainName);
			if(isTrainNameValid){
				System.out.println("train name is valid");
			TrainDTO trainDTO	= this.trainServiceImpl.getTrainDTOByTrainName(trainName);
			if(trainDTO != null) {
			model.addAttribute("TrainName",trainDTO.getTrainName());
			model.addAttribute("TrainSpeed", trainDTO.getTrainSpeed());
			model.addAttribute("TrainColor", trainDTO.getTrainColor());
			model.addAttribute("NoOfCompartments", trainDTO.getNoOfCompartments());
			model.addAttribute("NoOfWheels", trainDTO.getNoOfWheels());
			model.addAttribute("TrainType", trainDTO.getTrainType());
			}
			else {
				model.addAttribute("TrainNameNotFound" ,"no results for the " + trainName + "please enter the valid trainName.... "  );
			}
		}
			else {
				model.addAttribute("TrainNameNotFound", "enter the valid train name...");
			}	
			return "/WEB-INF/welcome.jsp";
		}
		
		
		@RequestMapping("/getAllTrainInformation")
		public String getAllTrainInformation(Model model) {
			System.out.println(" invoked getAllTrainInformation()");	
			List<Object> listOfTrainObject = this.trainServiceImpl.getListOfTrainObject();	
			model.addAttribute("getAllTrains", listOfTrainObject);
			return "/WEB-INF/welcome.jsp";
		}
		
		
		@RequestMapping("/deleteTrainName")
		public String deleteTrainByName(@RequestParam String trainName , Model model) {
			System.out.println("invoked deleteTrainByName() "+trainName);
			
			boolean validateTrain = this.trainServiceImpl.validateTrainName(trainName);
			if(validateTrain) {
				System.out.println("trainName is valid");
				
				boolean deleteTrain = this.trainServiceImpl.deleteByName(trainName);
				if(deleteTrain) {
                   model.addAttribute("Deleted", "entity object has been deleted successfully");
				}
				else {
                    model.addAttribute("Deleted", "not deleted please try again......in sometime");
				}
			}
			else {
				System.out.println("data is not valid");
			}
			return  "/WEB-INF/welcome.jsp";
		}
		
		
		@RequestMapping("/updateTrainEntity")
		public String updateTrainEntity(@ModelAttribute TrainDTO trainDTO , Model model) {
			System.out.println("invoked updateTrainEntity()");
			boolean isUserDataValid = this.trainServiceImpl.validateUserData(trainDTO);
			if(isUserDataValid) {
				boolean isTrainEntityUpdated = this.trainServiceImpl.updateTrainEntity(trainDTO);
				if(isTrainEntityUpdated) {
					model.addAttribute("ErrorTrainName", "updated TrainEntity details conjaajulationssss...");
				}
				else {
					model.addAttribute("ErrorTrainName", "not updated maccha please drink water and try again");
				}
			}
			else {
				System.out.println("user data valid ....please verify it");
				 Map<String, String> mapContainer = TrainServiceImpl.mapContainer ;
				  model.addAttribute("errorTrainName", mapContainer.get("TRAINNAME"));
				  model.addAttribute("errorTrainSpeed" ,mapContainer.get("TRAINSPEED"));
				  model.addAttribute("errorTrainColor" ,mapContainer.get("TRAINCOLOR"));
				  model.addAttribute("errorInCompart" ,mapContainer.get("NOOFCOMPARTMENTS"));
				  model.addAttribute("errorInNumber" ,mapContainer.get("NOOFWHEELS"));
				  model.addAttribute("errorInTrainType" ,mapContainer.get("TRAINTYPE"));
			}
			return "/WEB-INF/welcome.jsp";
		}
}	

