package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.TransformDtoUser;
import fr.istic.master.wego.dto.UserDtoCreate;
import fr.istic.master.wego.dto.UserDtoRead;
import fr.istic.master.wego.model.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<UserDtoRead> getAllUsers(){
        List<UserDtoRead> listDto = new ArrayList<>();
        List<User> listDao = userDao.findAll();

        for(User user: listDao){
            listDto.add(TransformDtoUser.transformToDto(user));
        }

        return listDto;
    }

    public UserDtoRead getUserById(long id){
        User user = userDao.findById(id).orElse(null);
        if (user.equals(null)){
            return null;
        }else{
            return TransformDtoUser.transformToDto(user);
        }
    }

    public UserDtoRead getUserByEmail(String email){
        User user = userDao.findByEmail(email).orElse(null);
        if (user.equals(null)){
            return null;
        }else{
            return TransformDtoUser.transformToDto(user);
        }
    }

    public void createUser(UserDtoCreate userDto){
        userDao.save(TransformDtoUser.transformFromDto(userDto));
    }

    public void updateUser(Long id, UserDtoCreate userDto){
    	User u = userDao.getOne(id);
        userDao.save(TransformDtoUser.transformFromDto(userDto, u));
    }

    public void deleteUser(long id){
        userDao.deleteById(id);
    }


}
