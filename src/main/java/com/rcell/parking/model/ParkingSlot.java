package com.rcell.parking.model;

/**
 * 
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parkingslot")
public class ParkingSlot implements Serializable {

	/**
	   * 
	   */
	private static final long serialVersionUID = 5124000706092599751L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long slotId;

	@NotNull
	@Column(name = "parkingno")
	String parkingNo;

	@Column(name = "status")
	String status;
	
	@Column(name = "address")
	String address;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
