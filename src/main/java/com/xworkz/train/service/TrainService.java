package com.xworkz.train.service;


import java.util.List;

import com.xworkz.train.dto.TrainDTO;
import com.xworkz.train.entity.TrainEntity;

public interface TrainService {

	boolean saveAllUserData(TrainDTO trainDTO);

	boolean validateUserData(TrainDTO trainDTO);
	
	boolean validateTrainName(String trainName);
	
	TrainDTO getTrainDTOByTrainName(String trainName);
	
	List<Object> getListOfTrainObject();
	
	boolean deleteByName(String trainName);
	
	boolean updateTrainEntity(TrainDTO trainDTO);
	
}
