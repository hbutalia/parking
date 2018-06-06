package com.rcell.parking.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rcell.parking.model.ParkingSlot;

@RepositoryRestResource(exported = false)
public interface ParkingRepository extends PagingAndSortingRepository<ParkingSlot, Long> {

//  List<ParkingSlot> findTop10ByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title,
//      String content);

}
