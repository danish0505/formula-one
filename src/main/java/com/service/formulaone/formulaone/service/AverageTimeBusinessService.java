package com.service.formulaone.formulaone.service;

import org.springframework.http.ResponseEntity;

import com.service.formulaone.formulaone.response.AveragePitStopResponse;

public interface AverageTimeBusinessService {

	ResponseEntity<AveragePitStopResponse> getAverage(String year, String threshold);

}
