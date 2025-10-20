package app.ctf.ctf_academy.repo;

import app.ctf.ctf_academy.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface ChallengeRepo extends JpaRepository<Challenge,Long>{
    Optional<Challenge> findBySlug(String slug);
    List<Challenge> findByPublishedTrueOrderByIdAsc();
}
