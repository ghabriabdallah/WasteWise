package codadoor.pfe.auth;

import javax.security.auth.login.AccountLockedException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import codadoor.pfe.config.JwtService;
import codadoor.pfe.entity.Role;
import codadoor.pfe.entity.*;
import codadoor.pfe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
	    if (repository.findByEmail(request.getEmail()).isPresent()) {
	        throw new EmailAlreadyExistsException("Email already exists");
	    }

	    String password = request.getPassword();
	    if (password.length() < 6 || password.length() > 30 || !password.matches("^[a-zA-Z0-9]*$")) {
	        throw new InvalidPasswordException("Invalid password. Password must be between 6 and 30 characters and contain no special characters.");
	    }

	    var user = User.builder()
	        .firstName(request.getFirstName())
	        .lastName(request.getLastName())
	        .email(request.getEmail())
	        .numTel(request.getNumTel())
	        .adress(request.getAdress())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .role(Role.USER)
	        .build();
	    repository.save(user);
	    var jwtToken = jwtService.generateToken(user);
	    return AuthenticationResponse.builder()
	        .token(jwtToken)
	        .build();
	}

  public AuthenticationResponse registerAdmin(RegisterRequest request) {
	    if (repository.findByEmail(request.getEmail()).isPresent()) {
	        throw new EmailAlreadyExistsException("Email already exists");
	    }

	    String password = request.getPassword();
	    if (password.length() < 6 || password.length() > 30 || !password.matches("^[a-zA-Z0-9]*$")) {
	        throw new InvalidPasswordException("Invalid password. Password must be between 6 and 30 characters and contain no special characters.");
	    }

	    var user = User.builder()
	        .firstName(request.getFirstName())
	        .lastName(request.getLastName())
	        .email(request.getEmail())
	        .numTel(request.getNumTel())
	        .adress(request.getAdress())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .role(Role.ADMIN)
	        .build();
	    repository.save(user);
	    var jwtToken = jwtService.generateADMINToken(user);
	    return AuthenticationResponse.builder()
	        .token(jwtToken)
	        .build();
	}

  public AuthenticationResponse registerDriver(RegisterRequest request) {
	    if (repository.findByEmail(request.getEmail()).isPresent()) {
	        throw new EmailAlreadyExistsException("Email already exists");
	    }

	    String password = request.getPassword();
	    if (password.length() < 6 || password.length() > 30 || !password.matches("^[a-zA-Z0-9]*$")) {
	        throw new InvalidPasswordException("Invalid password. Password must be between 6 and 30 characters and contain no special characters.");
	    }

	    var user = User.builder()
	        .firstName(request.getFirstName())
	        .lastName(request.getLastName())
	        .email(request.getEmail())
	        .numTel(request.getNumTel())
	        .adress(request.getAdress())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .role(Role.DRIVER)
	        .UID(request.getUid())
	        .build();
	    repository.save(user);
	    var jwtToken = jwtService.generateDriverToken(user);
	    return AuthenticationResponse.builder()
	        .token(jwtToken)
	        .build();
	}
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
	    try {
	        authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                request.getEmail(),
	                request.getPassword()
	            )
	        );
	    } catch (AuthenticationException e) {
	        throw new InvalidCredentialsException("Invalid email/password");
	    }

	    var user = repository.findByEmail(request.getEmail())
	        .orElseThrow(() -> new UserNotFoundException("User not found"));
	    var jwtToken = jwtService.generateToken(user);
	    return AuthenticationResponse.builder()
	        .token(jwtToken)
	        .build();
	}


}
