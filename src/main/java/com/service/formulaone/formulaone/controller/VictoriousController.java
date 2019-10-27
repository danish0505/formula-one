package com.service.formulaone.formulaone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.formulaone.formulaone.exception.BusinessException;
import com.service.formulaone.formulaone.response.MostVictoriousResponse;
import com.service.formulaone.formulaone.service.VictoriousBusinessSerice;
import com.service.formulaone.formulaone.utility.ValidateUtils;

@RestController()
@RequestMapping(path = "/v1")
public class VictoriousController {

	@Autowired
	private VictoriousBusinessSerice victoriousService;

	@Autowired
	private ValidateUtils utility;

	@GetMapping(path = "/mostVictorious")
	public ResponseEntity<MostVictoriousResponse> getMostVictorious(@RequestParam(required = true) String initailYear,
			@RequestParam(required = true) String finalYear) throws BusinessException {
		ResponseEntity<MostVictoriousResponse> response = null;

		if (utility.validateYearData(initailYear, finalYear) == null) {
			response = victoriousService.getMostVictorious(initailYear, finalYear);
		} else {
			throw new BusinessException("Inavlid Data");
		}
		return response;

	}

}
