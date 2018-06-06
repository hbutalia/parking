package com.rcell.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcell.parking.model.ParkingSlot;
import com.rcell.parking.service.ParkingService;

@RestController
public class ParkingController {

	@Autowired
	ParkingService parkingService;

	@PostMapping(path = "parkings")
	public ResponseEntity<ParkingSlot> createparking(@RequestBody ParkingSlot parking) {
		final ResponseEntity<ParkingSlot> msgParking = performValidation(parking);
		if (msgParking != null) {
			return msgParking;
		}
		return new ResponseEntity<>(parkingService.save(parking), HttpStatus.CREATED);
	}

	private ResponseEntity<ParkingSlot> performValidation(final ParkingSlot parking) {
		final String errMsg = validateParking(parking);
		if (errMsg != null && !errMsg.isEmpty()) {
			return new ResponseEntity<>(parking, HttpStatus.EXPECTATION_FAILED);
		}
		return null;
	}

	private String validateParking(final ParkingSlot parking) {
		if (parking == null) {
			return "No parking to save";
		}


		return null;

	}

	/**
	 * Api to get details of parking based on parking-id
	 * @param id
	 * @return
	 */
	@GetMapping(path = "parkings/{parking-id}")
	public ResponseEntity<ParkingSlot> getParkingById(@PathVariable("parking-id") Long id) {
		final ParkingSlot parking = parkingService.findById(id);
		if (parking != null) {
			return new ResponseEntity<>(parking, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Api for updating parking details
	 * @param id
	 * @param parking
	 * @return
	 */
	@PutMapping(path = "parkings/{parking-id}")
	public ResponseEntity<ParkingSlot> updateParking(@PathVariable("parking-id") Long id, @RequestBody ParkingSlot parking) {
		final ParkingSlot parkingRec = parkingService.findById(id);
		if (parkingRec != null) {
			final ResponseEntity<ParkingSlot> msgparking = performValidation(parking);
			if (msgparking != null) {
				return msgparking;
			}
			return new ResponseEntity<>(parkingService.save(parking), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "parkings/{parking-id}")
	public ResponseEntity<ParkingSlot> deleteParkingById(@PathVariable("parking-id") Long id) {
		parkingService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Api for listing parkings
	 * @param text
	 * @return
	 */
	@GetMapping(path = "parkings/search")
	public ResponseEntity<List<ParkingSlot>> searchParkings(@RequestParam(value = "text") String text) {
		return null;
	}

}
