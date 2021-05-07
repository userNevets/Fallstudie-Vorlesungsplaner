package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.UniUser;

import java.util.List;
import java.util.Optional;

public interface IUniUserService {

    UniUser save(UniUser uniUser);

    void delete(Long id);

    List<UniUser> findAll();

    Optional<UniUser> findOne(Long id);
}
