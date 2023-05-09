package codadoor.pfe.services;

import java.util.List;

import org.springframework.stereotype.Component;

import codadoor.pfe.entity.User;

@Component
public interface UserService {
	public  List<User>getAllUtilisateurs();
	public void deleteUser(long id);
	void changeDuty(Long id);
    User updateUserById(Long id, User user);
	User getUserByEmail(String email);
	public User updatePhotoById(Long id, byte[] photo);
	User EditProfileById(Long id, User user);

}
