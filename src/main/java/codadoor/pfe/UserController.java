package codadoor.pfe;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import codadoor.pfe.entity.User;
import codadoor.pfe.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	
	@GetMapping(path ="Admin/AllUsers") 
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public List<User> getAllUtilisateurs() {
		return  userService.getAllUtilisateurs();
	}
	
	@GetMapping(path="/Profile/{email}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public User getUserByEmail(@PathVariable String email) {
	    return userService.getUserByEmail(email);
	}

	@PutMapping(path = "/UpdatePhoto/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"}, methods = {RequestMethod.PUT})
	public ResponseEntity<User> updatePhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
	    User updatedUser = userService.updatePhotoById(id, file.getBytes());
	    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/downloadFile/")
	            .path(updatedUser.getId().toString())
	            .toUriString();
	    updatedUser.setPhotoUrl(fileDownloadUri);
	    return ResponseEntity.ok(updatedUser);
	}



	
	@DeleteMapping(path="/Admin/RemoveUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping(path = "/Admin/UpdateUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void updateUser(@PathVariable Long id, @RequestBody User user) {
	    userService.updateUserById(id, user);
	}


	@PutMapping(path = "/Admin/ChangeDuty/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void changeDuty(@PathVariable Long id) {
		userService.changeDuty(id);
	}
	
}
