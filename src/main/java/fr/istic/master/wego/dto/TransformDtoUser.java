package fr.istic.master.wego.dto;

import java.util.HashSet;

import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

public class TransformDtoUser {

    public static UserDto transformToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMail(user.getMail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public static User transformFromDto(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMail(userDto.getMail());
        user.setPassword(userDto.getPassword());
        user.setMyPlaces(new HashSet<UserPlace>());
        user.setMySports(new HashSet<UserSport>());

        return user;
    }
    
    public static User transformFromDto(UserDto userDto, User u){
        u.setFirstName(userDto.getFirstName());
        u.setLastName(userDto.getLastName());
        // on ne peut pas changer le mail de connexion
        u.setPassword(userDto.getPassword());
        u.setMyPlaces(new HashSet<UserPlace>());
        u.setMySports(new HashSet<UserSport>());

        return u;
    }
    

}
