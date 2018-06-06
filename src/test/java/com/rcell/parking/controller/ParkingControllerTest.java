package com.rcell.parking.controller;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Assert;
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
import org.springframework.http.ResponseEntity;
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

	@Test
	public void testBookParkingSlot() throws Exception {
		HttpEntity<Object> parkingSlot = getHttpEntity(
				"{\"email\": \"user1@gmail.com\", \"title\": \"testhelloonlycreate\" , \"title\": \"helloonlycreatecontent\"}");
		ResponseEntity<ParkingSlot> resultAsset = template.postForEntity("/parkingSlots", parkingSlot, ParkingSlot.class);
		Assert.assertNotNull(resultAsset.getBody().getSlotId());
	}

	@Test
	public void testGetParkingSlotById() throws Exception {
		ResponseEntity<ParkingSlot> resultGetAsset = template.getForEntity("/parkingSlots/1",
				ParkingSlot.class);
		Assert.assertEquals(resultGetAsset.getBody().getSlotId(), new Long(1));
	}

	@Test
	public void testSearchParkingSlot() throws Exception {
		ResponseEntity<List> aList = template.getForEntity("/parkingSlots/search",
				List.class);
		final List<ParkingSlot> parkingSlots = aList.getBody();
		LOGGER.info("testSearchParkingSlot " + parkingSlots.size());
		assertFalse("Minimun one records should exists.", (parkingSlots.size() <= 0));
	}

	@Test
	public void testDeleteparkingSlotById() throws Exception {
		template.delete("/parkingSlots/1");
		ResponseEntity<ParkingSlot> resultGetAsset = template.getForEntity("/parkingSlots/1",
				ParkingSlot.class);
		Assert.assertNull(resultGetAsset.getBody());
	}

	@Test
	public void testUpdateParking() throws Exception {
		HttpEntity<Object> parkingSlot = getHttpEntity(
				"{\"id\": \"1\", \"status\": \"AVAILABLE\"}");
		ResponseEntity<ParkingSlot> resultAsset = template.postForEntity("/parkingSlots", parkingSlot, ParkingSlot.class);
		ParkingSlot updatedAr = resultAsset.getBody();
		updatedAr.setStatus("BOOKED");
		LOGGER.info("testUpdateParking ######## " + updatedAr.getSlotId());
		template.put("/parkingSlots/" + updatedAr.getSlotId(), updatedAr);
	}

	@Test
	public void testUpdateParkingNotFound() throws Exception {
		final ParkingSlot updatedAr = new ParkingSlot();
		updatedAr.setSlotId(0L);
		LOGGER.info("testUpdateParkingNotFound ######## " + updatedAr.getSlotId());
		template.put("/parkingSlots/" + updatedAr.getSlotId(), updatedAr);
	}

	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}
}
