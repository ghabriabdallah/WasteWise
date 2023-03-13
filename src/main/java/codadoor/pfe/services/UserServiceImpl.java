package codadoor.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.User;
import codadoor.pfe.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
	 userRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void changeDuty(Long id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if(userOptional.isPresent()) {
	        User user = userOptional.get();
	        user.setOnDuty(!user.isOnDuty());
	        userRepository.save(user);
	    } else {
	        throw new RuntimeException("User not found with id: " + id);
	    }
	}


}
