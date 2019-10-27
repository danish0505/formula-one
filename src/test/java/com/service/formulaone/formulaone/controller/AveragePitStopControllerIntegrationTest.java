package com.service.formulaone.formulaone.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.service.formulaone.formulaone.Application;
import com.service.formulaone.formulaone.response.AveragePitStopResponse;
import com.service.formulaone.formulaone.response.ExceptionResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class AveragePitStopControllerIntegrationTest {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private Environment env;

	@Test
	public void whenValid_Input() {
		String url = String.format(env.getProperty("validUrlAvg"));
		AveragePitStopResponse response = restTemplate.getForObject(url, AveragePitStopResponse.class);
		assertNotNull(response);
		

		
	}

	@Test(expected = Exception.class)
	public void whenInValid_Input() {
		String url = String.format(env.getProperty("invalidUrlAvg"));
		ExceptionResponse response = restTemplate.getForObject(url, ExceptionResponse.class);

	}

}
