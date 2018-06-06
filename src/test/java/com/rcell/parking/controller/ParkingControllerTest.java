package com.rcell.parking.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rcell.parking.model.ParkingSlot;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingControllerTest.class);

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setup() throws Exception {

	}

//	@Test
//	public void testCreateParkingSlot() throws Exception {
//		HttpEntity<Object> parkingSlot = getHttpEntity(
//				"{\"id\": \"1\", \"status\": \"AVAILABLE\", \"parkingNo\": \"A-10\"}");
//		ResponseEntity<ParkingSlot> resultAsset = template.postForEntity("/parkings", parkingSlot, ParkingSlot.class);
//		Assert.assertNotNull(resultAsset.getBody().getSlotId());
//	}
	
	@Test
	public void testBookParkingSlot() throws Exception {
		LOGGER.info("testBookParkingSlot ===>");
		final ParkingSlot parkingSlot = new ParkingSlot();
		parkingSlot.setSlotId(1L);
		template.put("/parkings/book/"+parkingSlot.getSlotId(),parkingSlot);
	}
	
	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}
}
