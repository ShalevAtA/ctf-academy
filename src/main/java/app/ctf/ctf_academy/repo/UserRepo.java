package app.ctf.ctf_academy.repo;
import app.ctf.ctf_academy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
