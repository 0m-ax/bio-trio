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

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (1, '1A', '0', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (2, '2A', '50', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (3, '3A', '100', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (4, '4A', '150', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (5, '5A', '200', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (6, '6A', '250', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (7, '7A', '300', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (8, '8A', '350', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (9, '9A', '400', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (10, '10A', '450', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (11, '11A', '500', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (12, '12A', '550', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (13, '13A', '600', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (14, '14A', '650', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (15, '15A', '700', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (16, '16A', '750', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (17, '17A', '800', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (18, '18A', '850', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (19, '19A', '900', '0', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (20, '20A', '950', '0', 1);

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (21, '1B', '0', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (22, '2B', '50', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (23, '3B', '100', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (24, '4B', '150', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (25, '5B', '200', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (26, '7B', '300', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (27, '6B', '250', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (28, '8B', '350', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (29, '9B', '400', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (30, '10B', '450', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (31, '11B', '500', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (32, '12B', '550', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (33, '13B', '600', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (34, '14B', '650', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (35, '15B', '700', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (36, '16B', '750', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (37, '17B', '800', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (38, '18B', '850', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (39, '19B', '900', '50', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (40, '20B', '950', '50', 1);

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (41, '1C', '0', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (42, '2C', '50', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (43, '3C', '100', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (44, '4C', '150', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (45, '5C', '200', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (46, '7C', '300', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (47, '6C', '250', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (48, '8C', '350', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (49, '9C', '400', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (50, '10C', '450', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (51, '11C', '500', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (52, '12C', '550', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (53, '13C', '600', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (54, '14C', '650', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (55, '15C', '700', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (56, '16C', '750', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (57, '17C', '800', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (58, '18C', '850', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (59, '19C', '900', '100', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (60, '20C', '950', '100', 1);

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (61, '1D', '0', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (62, '2D', '50', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (63, '3D', '100', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (64, '4D', '150', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (65, '5D', '200', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (66, '7D', '300', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (67, '6D', '250', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (68, '8D', '350', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (69, '9D', '400', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (70, '10D', '450', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (71, '11D', '500', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (72, '12D', '550', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (73, '13D', '600', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (74, '14D', '650', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (75, '15D', '700', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (76, '16D', '750', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (77, '17D', '800', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (78, '18D', '850', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (79, '19D', '900', '150', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (80, '20D', '950', '150', 1);

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (81, '1E', '0', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (82, '2E', '50', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (83, '3E', '100', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (84, '4E', '150', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (85, '5E', '200', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (86, '7E', '300', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (87, '6E', '250', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (88, '8E', '350', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (89, '9E', '400', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (90, '10E', '450', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (91, '11E', '500', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (92, '12E', '550', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (93, '13E', '600', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (94, '14E', '650', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (95, '15E', '700', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (96, '16E', '750', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (97, '17E', '800', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (98, '18E', '850', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (99, '19E', '900', '200', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (100, '20E', '950', '200', 1);

INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (101, '1F', '0', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (102, '2F', '50', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (103, '3F', '100', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (104, '4F', '150', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (105, '5F', '200', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (106, '7F', '300', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (107, '6F', '250', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (108, '8F', '350', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (109, '9F', '400', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (110, '10F', '450', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (111, '11F', '500', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (112, '12F', '550', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (113, '13F', '600', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (114, '14F', '650', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (115, '15F', '700', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (116, '16F', '750', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (117, '17F', '800', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (118, '18F', '850', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (119, '19F', '900', '250', 1);
INSERT INTO `db_example`.`seats` (`seatid`, `seat_name`, `x`, `y`, `screen_hallid`) VALUES (120, '20F', '950', '250', 1);

INSERT INTO `db_example`.`movie` (`movieid`, `age_rating`, `description`, `genre`, `image`, `length`, `name`, `renting_end`, `renting_start`, `video`) VALUES (1, 'G', 'In turn of the century London, a magical nanny employs music and adventure to help two neglected children become closer to their father.', 'Fantasyfilm/Musical', 'http://localhost:8080/img/mary-popins.jpg', 140, 'Mary Poppins', null, null, 'https://www.youtube-nocookie.com/embed/YfkEQDPlb8g');
insert INTO `db_example`.`screenings` (`screeningid`, `cleaning`, `start_time`, `movieid`, `projectionist_employeid`, `screen_hallid`) VALUES (1, 20, '2019-05-23 13:22:44', 1, 1, 1);
INSERT INTO `db_example`.`order_status` (`order_statusid`,`name`,`seat_taken`,`usable`) VALUES (1,"Awaiting payment",TRUE,FALSE);
INSERT INTO `db_example`.`order_status` (`order_statusid`,`name`,`seat_taken`,`usable`) VALUES (2,"Paid",TRUE,TRUE);
INSERT INTO `db_example`.`order_status` (`order_statusid`,`name`,`seat_taken`,`usable`) VALUES (3,"Refunded",FALSE,FALSE);
INSERT INTO `db_example`.`order_status` (`order_statusid`,`name`,`seat_taken`,`usable`) VALUES (4,"Payment Cancled",FALSE,FALSE);
INSERT INTO `db_example`.`orders` (`order_number`,`order_statusid`, `customerid`) VALUES (1,1, 1);
INSERT INTO `db_example`.`tickets` (`ticketid`,`ticket_number`, `ticket_status`, `order_number`, `screeningid`, `seatid`) VALUES (1,'1', '1', 1, 1, 1)