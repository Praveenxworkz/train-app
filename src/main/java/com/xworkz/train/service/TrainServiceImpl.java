package com.xworkz.train.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.xworkz.train.dao.TrainDAO;
import com.xworkz.train.dao.TrainDAOImpl;
import com.xworkz.train.dto.TrainDTO;
import com.xworkz.train.entity.TrainEntity;

@Component
public class TrainServiceImpl implements TrainService {
	
	@Autowired
	private TrainDAO trainDAO ;
	
	private static TrainEntity trainEntity ;
	
	public static Map<String, String> mapContainer = new HashMap<String ,String>();
	
	public TrainServiceImpl() {
		System.out.println("serviceImpl is created");
	}
	
	
	@Override
	public boolean validateUserData(TrainDTO trainDTO) {
		
		boolean flag = false;
		
			if (trainDTO.getTrainName() != null && !trainDTO.getTrainName().isEmpty() && !trainDTO.getTrainName().isBlank()) {
				flag = true;
				System.out.println("Name is valid : " + trainDTO.getTrainName());
			} else {
				flag = false;
				System.out.println("name is not valid");
				mapContainer.put("TRAINNAME","train name is not valid please enter the correct details");
			   return flag ;
            }
			
			if (trainDTO.getTrainSpeed() != null && !trainDTO.getTrainSpeed().isEmpty() && !trainDTO.getTrainSpeed().isBlank()) {
				flag = true;
				System.out.println("speed is valid :" + trainDTO.getTrainSpeed());
			} else {
				flag = false;
				System.out.println("speed is not valid");
				mapContainer.put("TRAINSPEED" , "speed cannot be integer write in terms of kph");
				return flag;
				
			}
			if (trainDTO.getTrainColor() != null && !trainDTO.getTrainColor().isEmpty() && !trainDTO.getTrainColor().isBlank()) {
				flag = true;
				System.out.println("color is valid :" + trainDTO.getTrainColor());
			} else {
				flag = false;
				System.out.println("color is not valid");
				mapContainer.put("TRAINCOLOR", "enter the suitable color of train");
				return flag;
				
			}
			if (trainDTO.getNoOfCompartments() > 0) {
				flag = true;
				System.out.println("NoOfCompartments is valid :" + trainDTO.getNoOfCompartments());
			} else {
				flag = false;
				System.out.println("NoOfCompartments is not valid");
				mapContainer.put("NOOFCOMPARTMENTS", "train compartments cannot be null and negative");
				return flag;
				
			}
			if (trainDTO.getNoOfWheels() > 0) {
				flag = true;
				System.out.println("noOfWheels is valid :" + trainDTO.getNoOfWheels());
			} else {
				flag = false;
				System.out.println("noOfWheels is not valid");	
				mapContainer.put("NOOFWHEELS", "train wheels cannot be negative write a positive integer");
				return flag;
				
			}
			if (trainDTO.getTrainType() != null && !trainDTO.getTrainType().isEmpty() && !trainDTO.getTrainType().isBlank()) {
				flag = true;
				System.out.println("TrainType is valid");
			} else {
				flag = false;
				System.out.println("TrainType is not valid");
				mapContainer.put("TRAINTYPE", "entered train type is not suitable for this train please provide specifically");
				return flag;
				}
				return flag ;
			}

		
		@Override
		public boolean saveAllUserData(TrainDTO trainDTO) {
			
//    	TrainEntity entity = new TrainEntity( trainDTO.getTrainName() , trainDTO.getTrainSpeed() ,
//	    trainDTO.getTrainColor() ,trainDTO.getNoOfCompartments(),trainDTO.getNoOfWheels() ,trainDTO.getTrainType());
		
	    trainEntity = new TrainEntity();
		BeanUtils.copyProperties(trainDTO, trainEntity);
			
		boolean isTrainEntitySaved = this.trainDAO.saveTrainEntity(trainEntity);
			return isTrainEntitySaved ;
		
	 }


		@Override
		public boolean validateTrainName(String trainName) {
			try {
				return trainName != null && !trainName.isEmpty() && !trainName.isBlank() ? true : false ;
			}
			catch(RuntimeException e) {
				System.out.println(e.getMessage());
				
			}
			
			return false;
		}


		@Override
		public TrainDTO getTrainDTOByTrainName(String trainName) {
			System.out.println("invoked getTrainDTOByTrainName()");
			TrainDTO trainDTO = null ;
		    trainEntity = this.trainDAO.findTrainEntityByTrainName(trainName);	
			if(trainEntity != null) {
				trainDTO = new TrainDTO();
				BeanUtils.copyProperties(trainEntity, trainDTO);
			}
			else {
				System.out.println("TrainEntity is null ... not able to copy from trainEntity to trainDTO");
			}
		
			return trainDTO ;
			
		}


		@Override
		public List<Object> getListOfTrainObject() {
          List<Object> listOfTrainObject = null ;
          List<TrainEntity> list = this.trainDAO.getListOfTrainEntity();
          if(list != null) {
        	  listOfTrainObject = new ArrayList<>();
        	  for(TrainEntity trainEntity : list) {
        		  listOfTrainObject.add(trainEntity);
        		  System.out.println(trainEntity.toString());
        	  }
          }			
			return listOfTrainObject;
		}


		public boolean deleteByName(String trainName) {
			System.out.println("invoked deleteByName");
			boolean result = this.trainDAO.deleteByName(trainName);
			
			return result;
		}


		@Override
		public boolean updateTrainEntity(TrainDTO trainDTO) {
              System.out.println("invoked updateTrainEntity()");
            BeanUtils.copyProperties(trainDTO, trainEntity);
			
			return this.trainDAO.updateTrainEntityByTrainName(trainEntity);
		}	 
}
