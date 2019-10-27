package com.service.formulaone.formulaone.utility;

import java.time.Year;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public final class ValidateUtils {

	public ResponseEntity<Object> validateYearData(String initailYear, String finalYear) {
		ResponseEntity<Object> response = null;
		Year firstYear = Year.of(Integer.parseInt(initailYear));
		Year lastYear = Year.of(Integer.parseInt(finalYear));
		if (checkYear(initailYear) && checkYear(finalYear) && lastYear.isAfter(firstYear)) {
			return response;
		}
		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	private boolean checkYear(String year) {
		if (Pattern.matches("^(19|[2-9][0-9])\\d{2}$", year)) {
			// throw new BusinessException("Invalid Year input");
			return true;
		}
		// return null;
		return false;
	}

	public ResponseEntity<Object> vaildateData(String year, String threshold) {
		ResponseEntity<Object> response = null;
		if (checkYear(year)) {
			return response;
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
