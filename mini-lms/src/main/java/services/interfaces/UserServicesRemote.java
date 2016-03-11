package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user);

	Boolean deleteUserById(Long id);

	Boolean updateUser(User user);

	User findUserById(Long id);

	List<User> findAllUsers();

}
