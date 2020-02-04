package com.tempature.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tempature.dto.ChartData;
import com.tempature.model.Tempature;
import com.tempature.repo.TempatureRepo;


@Service
public class TempatureServiceImpl{
	@Autowired
	private TempatureRepo tempatureRepo;
	@Autowired
	//@Qualifier("tempatureDataJdbcTemplate")
	private JdbcTemplate tempatureDataJdbcTemplate;
	
	public void save(Tempature tempature) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		tempature.setTime(formatter.format(new Date()));
		tempatureRepo.save(tempature);
	}
	
	public List<Tempature> listAll() {
		tempatureRepo.count();
		
		return tempatureRepo.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tempature> getUpdatedTematureData(long dataCount){
		List<Tempature> tempList= new ArrayList<Tempature>();
		long realCount =0;
		ChartData chartData = new ChartData();
		realCount = tempatureRepo.count();
		
		if(realCount>dataCount) {
			int diff = (int) (realCount -dataCount);
			Page<Tempature> page= tempatureRepo.findAll(
					 PageRequest.of(0, diff, Sort.by(Sort.Direction.DESC, "id")));
			tempList=page.getContent();
			
		}else
			tempList=null;
		return tempList;
		   
	}

	
}
