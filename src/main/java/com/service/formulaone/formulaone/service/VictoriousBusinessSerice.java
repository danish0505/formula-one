package com.service.formulaone.formulaone.service;

import org.springframework.http.ResponseEntity;

import com.service.formulaone.formulaone.response.MostVictoriousResponse;

public interface VictoriousBusinessSerice {
	
	public ResponseEntity<MostVictoriousResponse> getMostVictorious(String initailYear, String finalYear);


}
