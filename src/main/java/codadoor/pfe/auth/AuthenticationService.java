package codadoor.pfe.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import codadoor.pfe.config.JwtService;
import codadoor.pfe.entity.Role;
import codadoor.pfe.entity.*;
import codadoor.pfe.auth.AuthetificationResponse;
import codadoor.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	
	

	public AuthetificationResponse registerUser(RegisterRequest request) {
		var user = User.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthetificationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthetificationResponse authenticate(AuthetificationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
				);
		var user = repository.findByEmail(request.getEmail())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthetificationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
