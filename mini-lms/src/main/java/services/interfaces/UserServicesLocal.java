package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	Boolean addUser(User user);

	Boolean deleteUserById(Long id);

	Boolean updateUser(User user);

	User findUserById(Long id);

	List<User> findAllUsers();
}
