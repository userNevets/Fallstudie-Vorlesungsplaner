package dhbw.vs.uniplaner.service;

import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.interfaces.IUniUserService;
import dhbw.vs.uniplaner.repository.UniUserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UniUserService implements IUniUserService {

    private final UniUserRepository uniUserRepository;


    public UniUserService(UniUserRepository uniUserRepository) {
        this.uniUserRepository = uniUserRepository;
    }


    @Override
    public UniUser save(UniUser uniUser) {
        return uniUserRepository.save(uniUser);
    }

    @Override
    public void delete(Long id) {
        uniUserRepository.deleteById(id);
    }

    @Override
    public List<UniUser> findAll() {
        return uniUserRepository.findAll();
    }

    @Override
    public Optional<UniUser> findOne(Long id) {
        return uniUserRepository.findById(id);
    }
}
