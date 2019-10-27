package com.service.formulaone.formulaone.service.impl;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.formulaone.formulaone.response.CustomResponse;
import com.service.formulaone.formulaone.response.EntityResponse;
import com.service.formulaone.formulaone.response.MostVictoriousResponse;
import com.service.formulaone.formulaone.service.VictoriousBusinessSerice;

@Service
public class VictoriousBusinessSericeImpl implements VictoriousBusinessSerice {

	private static final Logger logger = LoggerFactory.getLogger(VictoriousBusinessSericeImpl.class);

	@Autowired
	private Environment env;

	@Override
	public ResponseEntity<MostVictoriousResponse> getMostVictorious(String initailYear, String finalYear) {

		logger.info("Inside the getMostVictorious method");
		ResponseEntity<MostVictoriousResponse> response = null;
		try {

			response = new ResponseEntity<MostVictoriousResponse>(buildResponse(initailYear, finalYear), HttpStatus.OK);

			logger.info("Sending the Response for the most victorious");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	private MostVictoriousResponse buildResponse(String initailYear, String finalYear) {
		List<EntityResponse> lst = new ArrayList<>();
		Year firstYear = Year.of(Integer.parseInt(initailYear));
		Year lastYear = Year.of(Integer.parseInt(finalYear));
		lastYear = lastYear.plusYears(1);
		StringBuffer uripath = new StringBuffer();
		EntityResponse res;
		RestTemplate restTemplate = new RestTemplate();
		do {
			// do operation
			uripath.append(env.getProperty("basepath"));
			uripath.append(firstYear.toString());
			uripath.append(env.getProperty("mostvictoriousurisecondpart"));
			res = restTemplate.getForObject(uripath.toString(), EntityResponse.class);
			lst.add(res);
			firstYear = firstYear.plusYears(1);
			uripath.delete(0, uripath.length());
		} while (lastYear.isAfter(firstYear));

		return new MostVictoriousResponse(generateResponse(lst));
	}

	private List<CustomResponse> generateResponse(List<EntityResponse> lst) {
		List<CustomResponse> lstResponse = new ArrayList<>();
		for (EntityResponse e : lst) {
			lstResponse.add(new CustomResponse(0,
					e.getMRData().getStandingsTable().getStandingsLists().get(0).getConstructorStandings().get(0)
							.getConstructor().getNationality(),
					Integer.parseInt(e.getMRData().getStandingsTable().getStandingsLists().get(0)
							.getConstructorStandings().get(0).getWins())));
		}
		Collections.sort(lstResponse, new Comparator<CustomResponse>() {

			@Override
			public int compare(CustomResponse o1, CustomResponse o2) {

				if (o1.getVictories() - o2.getVictories() == 0) {
					return o1.getNationality().compareTo(o2.getNationality());
				} else if (o1.getVictories() - o2.getVictories() > 0) {
					return -1;
				}

				return 1;

			}
		});

		lstResponse.forEach(e -> e.setRank(lstResponse.indexOf(e) + 1));

		return lstResponse;
	}

}
