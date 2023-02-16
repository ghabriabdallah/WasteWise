package codadoor.pfe.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise/auth/")
@RequiredArgsConstructor
public class AuthentificationController {

	private final AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<AuthetificationResponse> register(
			@RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.registerUser(request));

	}



@PostMapping("/authenticate")
public ResponseEntity<AuthetificationResponse> authenticate(
		@RequestBody AuthetificationRequest request){
	return ResponseEntity.ok(service.authenticate(request));
	};

}