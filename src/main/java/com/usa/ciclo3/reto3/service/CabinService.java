package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Cabin;
import com.usa.ciclo3.reto3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {
    
    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll() {
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int idCabin) {
        return cabinRepository.getCabin(idCabin);
    }

    public Cabin save(Cabin cabin) {
        if (cabin.getIdCabin() == null) {
            return cabinRepository.save(cabin);
        } else {
            Optional<Cabin> tmpCabin = cabinRepository.getCabin(cabin.getIdCabin());
            if (tmpCabin.isEmpty()) {
                return cabinRepository.save(cabin);
            } else {
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getIdCabin() != null) {
            Optional<Cabin> tmpCabin = cabinRepository.getCabin(cabin.getIdCabin());
            if (!tmpCabin.isEmpty()) {
                return cabinRepository.save(cabin);
            }
        }
        return cabin;
    }

    public boolean deleteCabin(int id) {
        Boolean result = getCabin(id).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return result;
    }
    
}
