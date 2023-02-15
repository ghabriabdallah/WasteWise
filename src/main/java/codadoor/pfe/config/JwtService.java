package codadoor.pfe.config;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "70337336763979244226452948404D635166546A576E5A7134743777217A2543";
	
	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	private java.security.Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
