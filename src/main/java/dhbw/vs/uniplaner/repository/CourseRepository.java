package dhbw.vs.uniplaner.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import dhbw.vs.uniplaner.domain.Course;

@Repository
@SuppressWarnings("unused")
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseName(String courseName);
    
    Optional<Course> findById(Long id);
}