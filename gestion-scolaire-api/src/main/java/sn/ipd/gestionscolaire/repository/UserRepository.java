package sn.ipd.gestionscolaire.repository;
import sn.ipd.gestionscolaire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}