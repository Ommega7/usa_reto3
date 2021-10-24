package com.usa.ciclo3.reto3.service;


import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.MessageRepository;
import com.usa.ciclo3.reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();        
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> tmpReservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (tmpReservation.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }  
    }
    
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> tmpReservation = reservationRepository.getReservation(reservation.getIdReservation());
            if (!tmpReservation.isEmpty()) {
                return reservationRepository.save(reservation);
            }
        }
        return reservation;
    }
    
    public boolean deleteReservation(int id) {
        Boolean result = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return result;
    }
    
    
}
