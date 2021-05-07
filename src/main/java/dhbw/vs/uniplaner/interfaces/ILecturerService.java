package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.Lecturer;

import dhbw.vs.uniplaner.interfaces.ILecturerService;
import dhbw.vs.uniplaner.repository.LecturerRepository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

public interface ILecturerService {

    Lecturer save(Lecturer lecturer);

    void delete(Long id);

    List<Lecturer> findAll();

    Optional<Lecturer> findOne(Long id);
}
