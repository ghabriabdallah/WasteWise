package codadoor.pfe.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
  
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String adress;
	private String numTel;
	private boolean active;
	private String roles;
	
	
	
	public User() {};
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String email) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public User(Long id, String username, String password, String adress, String numTel, boolean active, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.adress = adress;
		this.numTel = numTel;
		this.active = active;
		this.roles = roles;
	}
	
	
}
