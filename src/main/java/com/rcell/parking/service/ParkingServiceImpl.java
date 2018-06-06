package com.rcell.parking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcell.parking.model.ParkingSlot;
import com.rcell.parking.repository.ParkingRepository;


@Service
public class ParkingServiceImpl implements ParkingService {

  @Autowired
  ParkingRepository parkingRepository;

  public ParkingSlot save(ParkingSlot article) {
    return parkingRepository.save(article);
  }

  
  public ParkingSlot findById(Long id) {
    return parkingRepository.findById(id).orElse(null);
  }

  public void delete(Long id) {
    parkingRepository.deleteById(id);
  }

  public Iterable<ParkingSlot> search() {
    return parkingRepository.findAll();
  }

}