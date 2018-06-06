CREATE TABLE `parkingslot` (
  `slotid` int(11) NOT NULL AUTO_INCREMENT,
  `parkingno` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `usagestarttime` bigint(20) DEFAULT NULL,
  `usageendtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`slotid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
