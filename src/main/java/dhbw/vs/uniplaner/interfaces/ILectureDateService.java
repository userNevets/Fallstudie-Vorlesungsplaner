package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.LectureDate;

import dhbw.vs.uniplaner.interfaces.ILectureDateService;
import dhbw.vs.uniplaner.repository.LectureDateRepository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

public interface ILectureDateService {

    LectureDate save(LectureDate lecturedate);

    void delete(Long id);

    List<LectureDate> findAll();

    Optional<LectureDate> findOne(Long id);
}
