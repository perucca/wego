package fr.istic.master.wego.controller;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoCreate;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoRead;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.service.SportPlaceAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sportplaceassociations")
public class SportPlaceAssociationController {

    @Autowired
    private UserDao userDao;

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
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

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
