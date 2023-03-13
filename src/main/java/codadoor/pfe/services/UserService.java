package codadoor.pfe.services;

import java.util.List;

import org.springframework.stereotype.Component;

import codadoor.pfe.entity.User;

@Component
public interface UserService {
	public  List<User>getAllUtilisateurs();
	public void deleteUser(long id);
	void changeDuty(Long id);

}
