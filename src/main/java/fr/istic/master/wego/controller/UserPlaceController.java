//package fr.istic.master.wego.controller;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import fr.istic.master.wego.dao.PlaceDao;
//import fr.istic.master.wego.dao.UserDao;
//import fr.istic.master.wego.dao.UserPlaceDao;
//import fr.istic.master.wego.dto.PlaceDto;
//import fr.istic.master.wego.model.UserPlace;
//
///**
// * @author amontuwy REST services for UserPlace Management To be done
// */
//@RestController
//@RequestMapping("/userplaces")
//public class UserPlaceController {
//
//	@Autowired
//	private UserPlaceDao userPlaceDao;
//	@Autowired
//	private UserDao userDao;
//	@Autowired
//	private PlaceDao placeDao;
//
//	//Create a userplace
//	@PostMapping("")
//	public Optional<UserPlace> createUserPlace(@RequestBody @Valid UserPlaceDtoCreate updto) {
//		UserPlace up = new UserPlace();
//		up.setUser(userDao.getOne(updto.getUserid()));
//		up.setPlace(placeDao.getOne(updto.getPlaceid()));
//		up.setPreferenceOrder(updto.getPreferenceOrder());
//		UserPlace u = userPlaceDao.save(up);
//		return userPlaceDao.findById(u.getId());
//	}
//
//	//Read all userplaces
//	@GetMapping("")
//	Collection <UserPlaceDtoDisplay> getAllUserPlaces(){
//		Set<UserPlaceDtoDisplay> upd = new HashSet<UserPlaceDtoDisplay>(); //on cree un collection vide à retourner ensuite
//		List<UserPlace> updao = userPlaceDao.findAll(); //on recupere les user place en base
//		for (UserPlace p : updao) { //pour chaque userplace on crée le userplaceDtoDisplay correspondant
//			UserPlaceDtoDisplay tmp = new UserPlaceDtoDisplay();
//			PlaceDto pdto = new PlaceDto(p.getPlace().getId(), p.getPlace().getName(), p.getPlace().getPostCode());
//			tmp.setPlace(pdto);
//			tmp.setPreferenceOrder(p.getPreferenceOrder());
//			upd.add(tmp);
//		}
//		return upd;
//	}
//
//}
