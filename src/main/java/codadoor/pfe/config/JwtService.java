package codadoor.pfe.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Collection;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import codadoor.pfe.entity.Role;

@Service
public class JwtService {

  private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

 


  public String generateToken(UserDetails userDetails, Role role) {
	    return Jwts
	        .builder()
	        .claim("role", role.toString())
	        .setSubject(userDetails.getUsername())
	        .setIssuedAt(new Date(System.currentTimeMillis()))
	        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
	        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
	        .compact();
	}

  public String generateToken(UserDetails userDetails) {
	    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
	    if (authorities.stream().anyMatch(a -> a.getAuthority().equals(Role.ADMIN.toString()))) {
	        return generateToken(userDetails, Role.ADMIN);
	    }else if (authorities.stream().anyMatch(a -> a.getAuthority().equals(Role.DRIVER.toString()))) {
	        return generateToken(userDetails, Role.DRIVER);
		}
	    else {
		    return generateToken(userDetails, Role.USER);

		}
	}
  public String generateADMINToken(UserDetails userDetails) {
	    return generateToken(userDetails, Role.ADMIN);
  }
  public String generateDriverToken(UserDetails userDetails) {
	    return generateToken(userDetails, Role.DRIVER);
}




  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
