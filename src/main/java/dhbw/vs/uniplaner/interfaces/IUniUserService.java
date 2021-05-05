package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.UniUser;

import java.util.List;
import java.util.Optional;

public interface IUniUserService {

    public UniUser save(UniUser uniUser);

    public void delete(Long id);

    public List<UniUser> findAll();

    public Optional<UniUser> findOne(Long id);
}
