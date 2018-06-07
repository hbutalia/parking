CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `mobileno` bigint(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `parkingslot` (
  `slot_id` int(11) NOT NULL AUTO_INCREMENT,
  `parkingno` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`slot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `parkingbooking` (
  `bookingid` int(11) NOT NULL AUTO_INCREMENT,
  `slotid` int(11) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `starttime` bigint(20) NOT NULL,
  `endtime` bigint(20) DEFAULT NULL,
  `usagehrs` decimal(4,2) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`bookingid`),
  KEY `slotid_idx` (`slotid`),
  KEY `pb_customer_idx` (`customerid`),
  CONSTRAINT `pb_customer` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pb_slot` FOREIGN KEY (`slotid`) REFERENCES `parkingslot` (`slot_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

