package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.Lecture;

import dhbw.vs.uniplaner.interfaces.ILectureService;
import dhbw.vs.uniplaner.repository.LectureRepository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

public interface ILectureService {

    Lecture save(Lecture lecture);

    void delete(Long id);

    List<Lecture> findAll();

    Optional<Lecture> findOne(Long id);
}
