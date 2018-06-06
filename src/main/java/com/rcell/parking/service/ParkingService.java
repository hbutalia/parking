package com.rcell.parking.service;

import com.rcell.parking.model.ParkingSlot;

/*
 * This interface provides all methods to access the functionality. See ParkingServiceImpl for implementation.
 * 
 *
 */
public interface ParkingService {
  /*
   * Save the parkingslot.
   */
  ParkingSlot save(ParkingSlot parking);

  /*
   * FindById will find the specific parkingslot list.
   * 
   */
  ParkingSlot findById(Long id);

  /*
   * Delete a particular parking slot
   */
  void delete(Long id);

  /*
   * Search parkingslot Table return result with pagination.
   */
  Iterable<ParkingSlot> search();

}
