package fr.istic.master.wego.service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.TransformDtoUser;
import fr.istic.master.wego.dto.UserDto;
import fr.istic.master.wego.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public Collection<UserDto> getAllUsers(){
        List<UserDto> listDto = new ArrayList<>();
        List<User> listDao = userDao.findAll();

        for(User user: listDao){
            listDto.add(TransformDtoUser.transformToDto(user));
        }

        return listDto;
    }

    public UserDto getUserById(long id){
        User user = userDao.findById(id).orElse(null);
        if (user.equals(null)){
            return null;
        }else{
            return TransformDtoUser.transformToDto(user);
        }
    }

    public User getFullUserById(long id){
        User user = userDao.findById(id).orElse(null);
        if (user.equals(null)){
            return null;
        }else{
            return user;
        }
    }

    public UserDto getUserByEmail(String email){
        User user = userDao.findByEmail(email).orElse(null);
        if (user.equals(null)){
            return null;
        }else{
            return TransformDtoUser.transformToDto(user);
        }
    }

    public void createUser(UserDto userDto){
        userDao.save(TransformDtoUser.transformFromDto(userDto));
    }

    //Not very clean?
    public void updateUser(long id, UserDto userDto){
        userDao.save(TransformDtoUser.transformFromDtoWithId(id, userDto));
    }

    public void deleteUser(long id){
        userDao.deleteById(id);
    }
}
