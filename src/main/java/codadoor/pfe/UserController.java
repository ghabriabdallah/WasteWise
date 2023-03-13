package codadoor.pfe;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codadoor.pfe.entity.User;
import codadoor.pfe.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise/Admin")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	
	@GetMapping(path ="/AllUsers") 
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public List<User> getAllUtilisateurs() {
		return  userService.getAllUtilisateurs();
	}
	
	@DeleteMapping(path="/RemoveUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	@PutMapping(path = "/ChangeDuty/{id}")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
	public void changeDuty(@PathVariable Long id) {
		userService.changeDuty(id);
	}
	
}
