package com.tempature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tempature.common.GeneralResponse;
import com.tempature.model.Tempature;
import com.tempature.service.TempatureServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class TempatureController {
	@Autowired
	private TempatureServiceImpl tempatureService;

	@RequestMapping(value = "/saveTempature", method = RequestMethod.POST)
	public ResponseEntity<GeneralResponse> saveTempature(@Valid @RequestBody Tempature tempature) {
		tempatureService.save(tempature);
		return ResponseEntity.ok().body(new GeneralResponse(null, true, "Save Success"));
	}

	@GetMapping("/tempature")
	public List<Tempature> getTempatureData() {
		return (List<Tempature>) tempatureService.listAll();
	}
	
	@GetMapping("/latestTempature/{count}")
	public List<Tempature> getLatestTempatureData(@PathVariable(name = "count") int count){
		
		return  (List<Tempature>) tempatureService.getUpdatedTematureData(count);
		
	}
}
