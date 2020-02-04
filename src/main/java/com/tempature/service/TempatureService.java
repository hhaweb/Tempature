package com.tempature.service;

import java.util.List;

import com.tempature.model.Tempature;

public interface TempatureService{
	 List<Tempature> getUpdatedTematureData(long dataCount);
}
