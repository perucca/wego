package fr.istic.master.wego.dto.transform;

import java.util.HashSet;

import org.springframework.util.CollectionUtils;

import fr.istic.master.wego.dto.UserDtoCreate;
import fr.istic.master.wego.dto.UserDtoRead;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

public class TransformDtoUser {

    public static UserDtoRead transformToDto(User user){
        UserDtoRead userDto = new UserDtoRead();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMail(user.getMail());
        if (! CollectionUtils.isEmpty(user.getMyPlaces()))
        	userDto.setMyPlacesEmpty(false);
        else
        	userDto.setMyPlacesEmpty(true);
        if (! CollectionUtils.isEmpty(user.getMySports()))
        	userDto.setMySportsEmpty(false);
        else
        	userDto.setMySportsEmpty(true);
        return userDto;
    }

    public static User transformFromDto(UserDtoCreate userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMail(userDto.getMail());
        user.setPassword(User.PASSWORD_ENCODER.encode(userDto.getPassword()));
        user.setMyPlaces(new HashSet<UserPlace>());
        user.setMySports(new HashSet<UserSport>());

        return user;
    }
    
    public static User transformFromDto(UserDtoCreate userDto, User u){
        u.setFirstName(userDto.getFirstName());
        u.setLastName(userDto.getLastName());
        // on ne peut pas changer le mail de connexion
        u.setPassword(User.PASSWORD_ENCODER.encode(userDto.getPassword()));
        u.setMyPlaces(new HashSet<UserPlace>());
        u.setMySports(new HashSet<UserSport>());
        return u;
    }
    

}
