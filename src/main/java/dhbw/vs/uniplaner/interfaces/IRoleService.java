package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.Role;

import dhbw.vs.uniplaner.interfaces.IRoleService;
import dhbw.vs.uniplaner.repository.RoleRepository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

public interface IRoleService {

    Role save(Role role);

    void delete(Long id);

    List<Role> findAll();

    Optional<Role> findOne(Long id);
}
