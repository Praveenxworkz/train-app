package com.xworkz.train.dao;

import java.util.List;

import com.xworkz.train.entity.TrainEntity;

public interface TrainDAO {

	boolean saveTrainEntity(TrainEntity trainEntity);

	TrainEntity findTrainEntityByTrainName(String trainName);
	
	List<TrainEntity> getListOfTrainEntity();

	boolean deleteByName(String trainName);

	boolean updateTrainEntityByTrainName(TrainEntity trainEntity);
	
}
