package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

import java.util.HashSet;

public class TransformDtoUser {

    public static UserDto transformToDto(User user){
        UserDto userDto = new UserDto();

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

    public static User transformFromDtoWithId(long id, UserDto userDto){
        User user = TransformDtoUser.transformFromDto(userDto);
        user.setId(id);
        return user;
    }
}
