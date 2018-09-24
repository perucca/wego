package fr.istic.master.wego.service;

import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.dto.TransformDtoUserSport;
import fr.istic.master.wego.dto.UserSportDto;
import fr.istic.master.wego.model.UserSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserSportService {

    @Autowired
    private UserSportDao userSportDao;

    public Collection<UserSportDto> getAllUserSportByUserId(long id){
        List<UserSport> userSports = userSportDao.findByUserId(id);
        List<UserSportDto> userSportDto = new ArrayList<>();

        for(UserSport userSport: userSports){
            userSportDto.add(TransformDtoUserSport.toDto(userSport));
        }

        return userSportDto;
    }

}
