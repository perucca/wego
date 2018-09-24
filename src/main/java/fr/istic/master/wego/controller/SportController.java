package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.SportDto;
import fr.istic.master.wego.service.SportService;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("")
    public Collection<SportDto> getAllSports() {
        return sportService.getAllSports();
    }

    @GetMapping("/{id}")
    public SportDto getSportById(@PathVariable("id") Long id) {
        return sportService.getSportById(id);
    }
}
