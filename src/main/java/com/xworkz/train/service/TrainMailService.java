package com.xworkz.train.service;

import com.xworkz.train.dto.TrainMailDTO;

public interface TrainMailService {

	boolean validTrainMail(TrainMailDTO trainMailDTO);

	boolean sendMail(TrainMailDTO trainMailDTO);


}
