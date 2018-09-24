package fr.istic.master.wego.controller;


import fr.istic.master.wego.dto.UserPlaceDto;
import fr.istic.master.wego.dto.UserSportDto;
import fr.istic.master.wego.model.UserSport;
import fr.istic.master.wego.service.UserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/usersports")
public class UserSportController {
    @Autowired
    private UserSportService userSportService;

    @GetMapping("/byuser/{id}")
    public Collection<UserSportDto> getUserSportsByUserId(@PathVariable("id") Long id) {
        return userSportService.getAllUserSportByUserId(id);
    }
}
