package com.service.formulaone.formulaone.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.formulaone.formulaone.response.AveragePitStopResponse;
import com.service.formulaone.formulaone.response.Constructor;
import com.service.formulaone.formulaone.response.CustomAverageTimeResponse;
import com.service.formulaone.formulaone.response.CustomResponse;
import com.service.formulaone.formulaone.response.Driver;
import com.service.formulaone.formulaone.response.EntityResponse;
import com.service.formulaone.formulaone.response.PitStop;
import com.service.formulaone.formulaone.response.Race;
import com.service.formulaone.formulaone.service.AverageTimeBusinessService;

@Service
public class AverageTimeBusinessServiceImpl implements AverageTimeBusinessService {

	private static final Logger logger = LoggerFactory.getLogger(AverageTimeBusinessServiceImpl.class);

	@Autowired
	private Environment env;

	@Override
	public ResponseEntity<AveragePitStopResponse> getAverage(String year, String threshold) {
		ResponseEntity<AveragePitStopResponse> response;
		List<String> constructorList = fetchConstructorList(year);
		Map<String, List<String>> constDrivrRelatnMap = buildConstructorDriverMap(constructorList, year);

		List<CustomAverageTimeResponse> lstResp = buildAverageRespone(constDrivrRelatnMap, year);
		response = new ResponseEntity<AveragePitStopResponse>(new AveragePitStopResponse(lstResp), HttpStatus.OK);

		return response;
	}

	private List<CustomAverageTimeResponse> buildAverageRespone(Map<String, List<String>> constDrivrRelatnMap,
			String year) {
		List<String> pitStopTimeList;
		List<CustomAverageTimeResponse> lstAvrgeTmeResponsLst = new ArrayList<>();
		for (String s : constDrivrRelatnMap.keySet()) {
			List<String> drivers = constDrivrRelatnMap.get(s);

			pitStopTimeList = new ArrayList<>();
			for (String driver : drivers) {

				RestTemplate restTemplate = new RestTemplate();
				StringBuffer path = new StringBuffer();
				path.append(env.getProperty("basepath"));
				// path.append("/");
				path.append(year);
				path.append("/");
				// path.append("round");

				for (int i = 1; i < 22; i++) {
					path.append(i);
					path.append("/drivers/");
					path.append(driver);
					path.append("/pitstops.json");

					EntityResponse res = restTemplate.getForObject(path.toString(), EntityResponse.class);
					if (null != res) {
						List<Race> races = res.getMRData().getRaceTable().getRaces();
						for (Race rs : races) {
							List<PitStop> pitStopsInfo = rs.getPitStops();
							for (PitStop p : pitStopsInfo) {
								String pitStopTime = p.getTime();
								pitStopTimeList.add(pitStopTime);

							}
						}
					}

					path.delete(30, path.length());
				}

			}

			// Here
			System.out.println("Constructor " + s + "Time " + pitStopTimeList);
			logger.info("Constructor " + s + "Time " + pitStopTimeList.size());
			CustomAverageTimeResponse custm = new CustomAverageTimeResponse();
			custm.setConstructorName(s);
			pitStopTimeList.stream().max(Comparator.comparing(i -> i)) //
					.ifPresent(max -> custm.setSlowestPitStopTime(max));

			pitStopTimeList.stream() //
					.min(Comparator.comparing(i -> i)) //
					.ifPresent(min -> custm.setFastestPitStopTime(min));

			custm.setAveragePitStopTime(calculateAverageOfTime(pitStopTimeList));
			lstAvrgeTmeResponsLst.add(custm);

		}

		// sort the element of lstAvrgeTmeResponsLst by average time

		Collections.sort(lstAvrgeTmeResponsLst, new Comparator<CustomAverageTimeResponse>() {

			@Override
			public int compare(CustomAverageTimeResponse o1, CustomAverageTimeResponse o2) {

				return o1.getAveragePitStopTime().compareTo(o2.getAveragePitStopTime());

				/*
				 * if (o1.getVictories() - o2.getVictories() == 0) { return
				 * o1.getNationality().compareTo(o2.getNationality()); } else if
				 * (o1.getVictories() - o2.getVictories() > 0) { return -1; }
				 * 
				 * return 1;
				 */

			}
		});

		lstAvrgeTmeResponsLst.forEach(e -> e.setRank(lstAvrgeTmeResponsLst.indexOf(e) + 1));

		return lstAvrgeTmeResponsLst;

	}

	private String calculateAverageOfTime(List<String> pitStopTimeList) {
		long seconds = 0;

		for (String timestr : pitStopTimeList) {
			String[] hhmmss = timestr.split(":");
			seconds += Integer.valueOf(hhmmss[0]) * 60 * 60;
			seconds += Integer.valueOf(hhmmss[1]) * 60;
			seconds += Integer.valueOf(hhmmss[2]);
		}
		seconds /= pitStopTimeList.size();
		long hh = seconds / 60 / 60;
		long mm = (seconds / 60) % 60;
		long ss = seconds % 60;
		return String.format("%02d:%02d:%02d", hh, mm, ss);
	}

	private Map<String, List<String>> buildConstructorDriverMap(List<String> constructorList, String year) {
		Map<String, List<String>> constructorDriverMaps = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();
		StringBuffer path = new StringBuffer();
		for (String s : constructorList) {

			path.append(env.getProperty("basepath"));
			path.append(year);
			path.append("/constructors/");
			path.append(s);
			path.append("/drivers.json");
			EntityResponse res = restTemplate.getForObject(path.toString(), EntityResponse.class);
			if (null != res) {
				if (!constructorDriverMaps.containsKey(s)) {
					List<Driver> lstDriversObj = res.getMRData().getDriverTable().getDrivers();
					List<String> lstDrivers = lstDriversObj.stream().map(e -> e.getDriverId())
							.collect(Collectors.toList());
					constructorDriverMaps.put(s, lstDrivers);
				}
			}
			path.delete(0, path.length());
		}

		return constructorDriverMaps;

	}

	private List<String> fetchConstructorList(String year) {
		logger.info("Fetching the list of the Constructors for the Year " + year);
		List<String> constructorList = new ArrayList<String>();
		RestTemplate restTemplate = new RestTemplate();
		StringBuffer path = new StringBuffer();
		path.append(env.getProperty("basepath"));
		path.append(year);
		path.append(env.getProperty("constructorpath"));
		EntityResponse res = restTemplate.getForObject(path.toString(), EntityResponse.class);
		if (null != res) {
			List<Constructor> lst = res.getMRData().getConstructorTable().getConstructors();
			constructorList = lst.stream().map(e -> e.getConstructorId()).collect(Collectors.toList());
		}

		System.out.println(constructorList);
		return constructorList;

	}

}
