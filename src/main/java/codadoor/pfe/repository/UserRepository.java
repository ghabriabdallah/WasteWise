package codadoor.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import codadoor.pfe.entity.User;
import edu.iset.atelierWeb.entities.Utilisateur;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    
    Optional<User> findById(Long id);
    
    @Modifying
    @Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.email = :email, u.adress = :adress, u.numTel = :numTel, u.photo = :photo WHERE u.id = :id")
    void updateUser(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("adress") String adress, @Param("numTel") String numTel, @Param("photo") byte[] photo);

}
