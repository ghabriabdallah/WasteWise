package codadoor.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codadoor.pfe.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	public User  findByUsername(String username);

}
