package fr.istic.master.wego.controller;

import fr.istic.master.wego.dto.SportDto;
import fr.istic.master.wego.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
