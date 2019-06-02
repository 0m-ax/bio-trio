package com.biotrio.backend.controller;

import com.biotrio.backend.model.*;
import com.biotrio.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping(value = "/api/screenings")
@RepositoryRestController
public class ScreeningController {
    @Autowired
    private ScreeningRepo screeningRepo;
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private OrderStatusRepo orderStatusRepo;
    @Autowired
    private RoleRepo roleRepo;
    /**
     * creates an order
     * @param id screeningID to book
     * @param seatIDs seatIDs to book
     * @param bookAsAdmin should move straight into payed status
     * @return created order
     */
    @RequestMapping(method = POST, value = "/{screeningID}/book")
    public @ResponseBody ResponseEntity<?> bookSeats(@PathVariable(value="screeningID") int id, @RequestBody List<Integer> seatIDs,@RequestParam boolean bookAsAdmin) {
        Optional<Screening> screening = screeningRepo.findById(id);
        if(!screening.isPresent()){
            return ResponseEntity.notFound().build();
        }

        List<Seat> wantedSeats = new ArrayList<>();
        seatRepo.findAllById(seatIDs).forEach(wantedSeats::add);

        List<Seat> seatsInUse = seatRepo.getByAvalibleForScreeningID(id);
        // check if a selected seat has been booked.
        boolean seatBooked = false;
        for(Seat seatInUse : seatsInUse) {
            for (Seat seatWanted : wantedSeats) {
                if(seatInUse.getSeatID() == seatWanted.getSeatID()){
                    return ResponseEntity.badRequest().build();
                }
            }
        }

        boolean steatNotInScreening = false;
        for (Seat seatWanted : wantedSeats) {
            if(seatWanted.getScreenHall().getScreenHallID() != screening.get().getScreenHall().getScreenHallID()){
                return ResponseEntity.badRequest().build();
            }
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByEmail(auth.getName());
        if(user == null){
            return ResponseEntity.badRequest().build();
        }

        Order order;
        if(bookAsAdmin){
            if(user.getRoles().contains(roleRepo.findByRole("ADMIN"))){
                order = new Order(orderStatusRepo.findById(2).get());
            }else {
                return ResponseEntity.badRequest().build();
            }
        }else{
            order = new Order(orderStatusRepo.findById(1).get(),user);
        }

        List<Ticket> tickets = new LinkedList<>();
        for (Seat seatWanted : wantedSeats) {
            tickets.add(new Ticket(screening.get(),seatWanted,order,screening.get().getCost()));
        }

        orderRepo.save(order);
        ticketRepo.saveAll(tickets);
        return ResponseEntity.ok(order);
    }

}