USE biotrio;
--  List screenings for the homepage
select screening0_.screeningid as screenin1_7_, screening0_.cleaning as cleaning2_7_, screening0_.cost as cost3_7_, screening0_.movieid as movieid5_7_, screening0_.screen_hallid as screen_h6_7_, screening0_.start_time as start_ti4_7_ from screenings screening0_ inner join screen_halls screenhall1_ on screening0_.screen_hallid=screenhall1_.screen_hallid inner join cinemas cinema2_ on screenhall1_.cinemaid=cinema2_.cinemaid where cinema2_.cinemaid=1 and CURRENT_DATE<screening0_.start_time;
-- Screening information for the screening page (screening 1)
select screening0_.screeningid as screenin1_7_0_, screening0_.cleaning as cleaning2_7_0_, screening0_.cost as cost3_7_0_, screening0_.movieid as movieid5_7_0_, screening0_.screen_hallid as screen_h6_7_0_, screening0_.start_time as start_ti4_7_0_, movie1_.movieid as movieid1_2_1_, movie1_.age_rating as age_rati2_2_1_, movie1_.description as descript3_2_1_, movie1_.genre as genre4_2_1_, movie1_.image as image5_2_1_, movie1_.length as length6_2_1_, movie1_.name as name7_2_1_, movie1_.video as video8_2_1_, screenhall2_.screen_hallid as screen_h1_6_2_, screenhall2_.cinemaid as cinemaid3_6_2_, screenhall2_.name as name2_6_2_, cinema3_.cinemaid as cinemaid1_1_3_, cinema3_.address as address2_1_3_, cinema3_.description as descript3_1_3_, cinema3_.name as name4_1_3_ from screenings screening0_ left outer join movie movie1_ on screening0_.movieid=movie1_.movieid left outer join screen_halls screenhall2_ on screening0_.screen_hallid=screenhall2_.screen_hallid left outer join cinemas cinema3_ on screenhall2_.cinemaid=cinema3_.cinemaid where screening0_.screeningid=1;
-- List seats for screening page
select seats0_.screen_hallid as screen_h5_8_0_, seats0_.seatid as seatid1_8_0_, seats0_.seatid as seatid1_8_1_, seats0_.screen_hallid as screen_h5_8_1_, seats0_.seat_name as seat_nam2_8_1_, seats0_.x as x3_8_1_, seats0_.y as y4_8_1_ from seats seats0_ where seats0_.screen_hallid=1;
-- List taken seats for screening
select seat4_.seatid as seatid1_8_, seat4_.screen_hallid as screen_h5_8_, seat4_.seat_name as seat_nam2_8_, seat4_.x as x3_8_, seat4_.y as y4_8_ from screenings screening0_ inner join tickets tickets1_ on screening0_.screeningid=tickets1_.screeningid inner join orders order2_ on tickets1_.order_number=order2_.order_number inner join order_status orderstatu3_ on order2_.order_statusid=orderstatu3_.order_statusid inner join seats seat4_ on tickets1_.seatid=seat4_.seatid where orderstatu3_.seat_taken=1 and screening0_.screeningid=1;