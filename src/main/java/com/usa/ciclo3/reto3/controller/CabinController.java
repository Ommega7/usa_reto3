package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.model.Cabin;
import com.usa.ciclo3.reto3.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*; 

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cabin")
public class CabinController {
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getAll() {
        return cabinService.getAll();
    }
    
    @GetMapping("/{idCabin}")
    public Optional<Cabin> getCabin(@PathVariable("idCabin") int idCabin) {
        return cabinService.getCabin(idCabin);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return cabinService.save(cabin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin) {
        return cabinService.update(cabin);
    }
    
    @DeleteMapping("/{idCabin}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idCabin") int idCabin) {
        return cabinService.deleteCabin(idCabin);
    }   
    
}
      