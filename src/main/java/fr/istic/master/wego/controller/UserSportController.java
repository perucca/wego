package fr.istic.master.wego.controller;


import java.util.Collection;

import fr.istic.master.wego.dto.UserSportDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.istic.master.wego.dto.UserSportDtoRead;
import fr.istic.master.wego.service.UserSportService;

@RestController
@RequestMapping("/usersports")
public class UserSportController {
    @Autowired
    private UserSportService userSportService;

    @GetMapping("/byuser/{id}")
    public Collection<UserSportDtoRead> getUserSportsByUserId(@PathVariable("id") Long id) {
        return userSportService.getAllUserSportByUserId(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserSport(@RequestBody UserSportDtoCreate userSportDto) {
        userSportService.createUserSport(userSportDto);
    }
}
