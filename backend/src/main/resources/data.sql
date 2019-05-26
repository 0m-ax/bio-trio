# REPLACE INTO `role` VALUES (1,'ADMIN');
# REPLACE INTO `cinemas` VALUES (1,'Cinima 1','A chill place');
# # REPLACE INTO `movie` VALUES (1, '15', 'A fast film', 'horror','http://localhost:8080/img/mary-popins.jpg', 180, 'Big film', null, null);
# REPLACE INTO `users` VALUES (1, 1, '11 cool place', 'bobross@biotrio.com', 'Bob', 'Ross', null, '+447984114662');
# REPLACE INTO `user_role` VALUES (1, 1);
# REPLACE INTO `screen_halls` VALUES (1, '1', 1);
# REPLACE INTO `screenings` VALUES (10, '2019-05-22 15:22:13', 1, 1, 1,1);
INSERT INTO `db_example`.`role` (`role_id`, `role`) VALUES (1, 'ADMIN');
INSERT INTO `db_example`.`users` (`userid`, `active`, `address`, `email`, `first_name`, `last_name`, `password`, `phone`) VALUES (1, 1, '50 frankrigade', 'bobross@biotrio.com', 'Bob', 'Ross', '$2a$10$KCw8w.qBBmtT1/iFGaUMDeCi8qzepUI5HL4nXV4GDltQtb616lAWi', '+447984114662');
INSERT INTO `db_example`.`user_role` (`userid`, `role_id`) VALUES (1, 1);
INSERT INTO `db_example`.`cinemas` (`cinemaid`, `address`, `description`) VALUES (1, '14 larchway', 'A old place');
INSERT INTO `db_example`.`screen_halls` (`screen_hallid`, `name`, `cinemaid`) VALUES (1, 'Room 1', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (1, '1A', '1', '1', 1);
INSERT INTO `db_example`.`movie` (`movieid`, `age_rating`, `description`, `genre`, `image`, `length`, `name`, `renting_end`, `renting_start`, `video`) VALUES (1, 'G', 'In turn of the century London, a magical nanny employs music and adventure to help two neglected children become closer to their father.', 'Fantasyfilm/Musical', 'http://localhost:8080/img/mary-popins.jpg', 140, 'Mary Poppins', null, null, 'https://www.youtube.com/watch?v=YfkEQDPlb8g');
insert INTO `db_example`.`screenings` (`screeningid`, `cleaning`, `start_time`, `movieid`, `projectionist_employeid`, `screen_hallid`) VALUES (1, 20, '2019-05-23 13:22:44', 1, 1, 1);
INSERT INTO `db_example`.`orders` (`order_number`,`order_status`, `customerid`) VALUES (1,'1', 1);
INSERT INTO `db_example`.`tickets` (`ticketid`,`ticket_number`, `ticket_status`, `order_number`, `screeningid`, `seatid`) VALUES (1,'1', '1', 1, 1, 1)