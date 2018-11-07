package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.UserDtoCreate;
import fr.istic.master.wego.dto.UserDtoRead;
import fr.istic.master.wego.dto.transform.TransformDtoUser;
import fr.istic.master.wego.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Collection<UserDtoRead> getAllUsers() {
		List<UserDtoRead> listDto = new ArrayList<>();
		List<User> listDao = userDao.findAll();

		for (User user : listDao) {
			listDto.add(TransformDtoUser.transformToDto(user));
		}

		return listDto;
	}

	public UserDtoRead getUserById(Long id) {
		Objects.requireNonNull(id);
		User user = userDao.getOne(id);
		return TransformDtoUser.transformToDto(user);
	}

	public UserDtoRead getUserByEmail(String email) {
		Objects.requireNonNull(email);
		
		User user = userDao.findByEmail(email).orElseThrow(() -> new IllegalStateException("The email :" + email+ " is not found."));

		return TransformDtoUser.transformToDto(user);
	}

	public void createUser(UserDtoCreate userDto) {
		Objects.requireNonNull(userDto);
		Objects.requireNonNull(userDto.getFirstName());
		Objects.requireNonNull(userDto.getLastName());
		Objects.requireNonNull(userDto.getMail());
		Objects.requireNonNull(userDto.getPassword());
		
		userDao.save(TransformDtoUser.transformFromDto(userDto));
	}

	public void updateUser(Long id, UserDtoCreate userDto) {
		Objects.requireNonNull(id);
		Objects.requireNonNull(userDto);
		Objects.requireNonNull(userDto.getFirstName());
		Objects.requireNonNull(userDto.getLastName());
		Objects.requireNonNull(userDto.getPassword());

		if(Objects.isNull(userDto.getMail())) {
			throw new IllegalStateException("The mail must be null when updating the user!!");
		}
		
		User u = userDao.getOne(id);
		userDao.save(TransformDtoUser.transformFromDto(userDto, u));
	}

	public void deleteUser(Long id) {
		Objects.requireNonNull(id);
		
		userDao.deleteById(id);
	}

}
