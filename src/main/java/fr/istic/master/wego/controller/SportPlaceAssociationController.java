package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.SportPlaceAssociationDtoCreate;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoRead;
import fr.istic.master.wego.service.SportPlaceAssociationService;

@RestController
@RequestMapping("/sportplaceassociations")
public class SportPlaceAssociationController {

    @Autowired
    private SportPlaceAssociationService sportPlaceAssociationService;

    //CREATE
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSportPlaceAssociation(@RequestBody SportPlaceAssociationDtoCreate sportPlaceAssociationDtoCreate) {
        sportPlaceAssociationService.createSportPlaceAssociation(sportPlaceAssociationDtoCreate);
    }

    //READ
    @GetMapping("/byuser/{id}")
    public Collection<SportPlaceAssociationDtoRead> getSportPlaceAssociationsByUserId(@PathVariable("id") Long id) {
        return sportPlaceAssociationService.getAllSportPlaceAssociationByUserId(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public void updateSportPlaceAssociation(@PathVariable("id") Long id, @RequestBody SportPlaceAssociationDtoCreate sportPlaceAssociationDtoCreate) {
        sportPlaceAssociationService.updateSportPlaceAssociation(id, sportPlaceAssociationDtoCreate);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteSportPlaceAssociation(@PathVariable("id") Long id) {
        sportPlaceAssociationService.deleteSportPlaceAssociation(id);
    }

}
