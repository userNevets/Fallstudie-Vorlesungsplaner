package dhbw.vs.uniplaner.repository;

import dhbw.vs.uniplaner.domain.UniUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@SuppressWarnings("unused")
public interface UniUserRepository extends JpaRepository<UniUser, Long> {
    List<UniUser> findByName(String uniUserName);
    Optional<UniUser> findById(Long id);
}
