package dhbw.vs.uniplaner.service;


import dhbw.vs.uniplaner.domain.Course;
import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.interfaces.IUniUserService;
import dhbw.vs.uniplaner.repository.UniUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UniUserService implements IUniUserService {

    Logger logger = LoggerFactory.getLogger(UniUserService.class);

    private final UniUserRepository uniUserRepository;

    public UniUserService(UniUserRepository uniUserRepository) {
        this.uniUserRepository = uniUserRepository;
    }

    @Override
    public UniUser save(UniUser uniUser) {
        logger.debug("Request to save Uniuser {}", uniUser);
        return uniUserRepository.save(uniUser);
    }


    @Override
    public void delete(Long id) {
        logger.debug("Request to delete Uniuser {}", id);
        uniUserRepository.deleteById(id);
    }

    @Override
    public List<UniUser> findAll() {
        logger.debug("Request to get all uniuser");
        return uniUserRepository.findAll();
    }

    @Override
    public Optional<UniUser> findOne(Long id) {
        logger.debug("Request to find Uniuser {}", id);
        return uniUserRepository.findById(id);
    }
}
