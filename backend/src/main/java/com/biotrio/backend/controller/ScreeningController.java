package com.biotrio.backend.controller;

import com.biotrio.backend.model.*;
import com.biotrio.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
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
        boolean seatBooked = false;
        Iterator<Seat> inUseIterator = seatsInUse.iterator();
        while (inUseIterator.hasNext()) {
            Seat seatInUser = inUseIterator.next();
            Iterator<Seat> wantedIterator = wantedSeats.iterator();
            while (wantedIterator.hasNext()) {
                Seat seatWanted = wantedIterator.next();
                if(seatInUser.getSeatID() == seatWanted.getSeatID()){
                    seatBooked = true;
                }
            }
        }
        if(seatBooked){
            return ResponseEntity.badRequest().build();
        }
        boolean steatNotInScreening = false;
        Iterator<Seat> wantedIterator = wantedSeats.iterator();
        while (wantedIterator.hasNext()) {
            Seat seatWanted = wantedIterator.next();
            if(seatWanted.getScreenHall().getScreenHallID() != screening.get().getScreenHall().getScreenHallID()){
                steatNotInScreening = true;
            }
        }
        if(steatNotInScreening){
            return ResponseEntity.badRequest().build();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByEmail(auth.getName());
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        Order order;
        if(bookAsAdmin){
            order = new Order(orderStatusRepo.findById(2).get());
        }else{
            order = new Order(orderStatusRepo.findById(1).get(),user);
        }
        Iterator<Seat> wantedFinalIterator = wantedSeats.iterator();
        List<Ticket> tickets = new LinkedList<>();
        while (wantedFinalIterator.hasNext()) {
            Seat seatWanted = wantedFinalIterator.next();
            tickets.add(new Ticket(screening.get(),seatWanted,order,screening.get().getCost()));
        }
        orderRepo.save(order);
        ticketRepo.saveAll(tickets);
        return ResponseEntity.ok(order);
    }

}