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
    
    
    public void Reg(UniUser user){
        System.out.println(user.toString());
        UniUser user2 = new UniUser(user.getfirst_name(), user.getlast_name(), user.getemail(), user.getPassword());
        //UniUser user2 = new UniUser("Max", "Mustermann", "zoidberg315@gmail.com", "test");
        System.out.println(user2.toString());
        uniUserRepository.save(user2);
        System.out.println("2");
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