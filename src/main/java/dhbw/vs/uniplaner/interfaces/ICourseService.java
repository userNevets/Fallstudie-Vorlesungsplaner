package dhbw.vs.uniplaner.interfaces;

import dhbw.vs.uniplaner.domain.Course;

import dhbw.vs.uniplaner.interfaces.ICourseService;
import dhbw.vs.uniplaner.repository.CourseRepository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

public interface ICourseService {

    Course save(Course course);

    void delete(Long id);

    List<Course> findAll();

    Optional<Course> findOne(Long id);
}
