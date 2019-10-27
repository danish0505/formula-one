package com.service.formulaone.formulaone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.formulaone.formulaone.exception.BusinessException;
import com.service.formulaone.formulaone.response.AveragePitStopResponse;
import com.service.formulaone.formulaone.service.AverageTimeBusinessService;
import com.service.formulaone.formulaone.utility.ValidateUtils;

@RestController()
@RequestMapping(path = "/v1")
public class AveragePitStopController {

	@Autowired
	private ValidateUtils utility;
	@Autowired
	private AverageTimeBusinessService averageBusinessService;

	@GetMapping(path = "/averageTime")
	public ResponseEntity<AveragePitStopResponse> getAverageTime(@RequestParam(required = true) String year,
			@RequestParam(required = true) String threshold) throws BusinessException {
		ResponseEntity<AveragePitStopResponse> response = null;
		if(utility.vaildateData(year, threshold)==null)
		{
			response = averageBusinessService.getAverage(year, threshold);
		}
		else {
			throw new BusinessException("Invalid Data");
		}

		return response;

	}
}
