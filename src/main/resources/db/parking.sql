CREATE TABLE parking.`parkingslot` (
  `slotid` int(11) NOT NULL,
  `parkingno` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `starttime` bigint(20) DEFAULT NULL,
  `endtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`slotid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;