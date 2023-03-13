package codadoor.pfe.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/WasteWise/auth")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  
  @PostMapping("/registerAdmin")
  @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
  public ResponseEntity<AuthenticationResponse> registerAdmin(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.registerAdmin(request));
  }
  
  @PostMapping("/addDriver")
  @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
  public ResponseEntity<AuthenticationResponse> addDriver(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.registerDriver(request));
  }
  
  @PostMapping("/authenticate")
  @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type"})
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }


}
