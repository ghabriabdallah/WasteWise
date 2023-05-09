package codadoor.pfe.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codadoor.pfe.entity.Role;
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
	public User getUserByEmail(String email) {
	    Optional<User> userOptional = userRepository.findByEmail(email);
	    if (userOptional.isPresent()) {
	        return userOptional.get();
	    } else {
	        return null;
	    }
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

	
	@Override
    public User updateUserById(Long id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setAdress(user.getAdress());
            existingUser.setNumTel(user.getNumTel());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

	@Override
	public User updatePhotoById(Long id, byte[] photo) {
	    Optional<User> existingUserOptional = userRepository.findById(id);
	        
	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();
	        
	        // generate a unique URL for the photo
	        String photoUrl = "https://example.com/photos/" + UUID.randomUUID().toString();
	        
	        // set the photo URL and save the user entity
	        existingUser.setPhotoUrl(photoUrl);
	        existingUser.setPhoto(photo);
	        return userRepository.save(existingUser);
	    } else {
	        throw new RuntimeException("User not found");
	    }
	}
	@Override
	public User EditProfileById(Long id, User user) {
	    Optional<User> existingUserOptional = userRepository.findById(id);

	    if (existingUserOptional.isPresent()) {
	        User existingUser = existingUserOptional.get();
	        existingUser.setFirstName(user.getFirstName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPassword(user.getPassword());
	        existingUser.setAdress(user.getAdress());
	        existingUser.setAdditionalAdress(user.getAdditionalAdress());
	        existingUser.setPostalCode(user.getPostalCode());
	        existingUser.setNumTel(user.getNumTel());
	        
	        existingUser.setRole(Role.USER);

	        return userRepository.save(existingUser);
	    } else {
	        throw new RuntimeException("User not found");
	    }
	}








}
