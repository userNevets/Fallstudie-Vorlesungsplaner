package dhbw.vs.uniplaner.repository;


import dhbw.vs.uniplaner.domain.UniUser;
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
    @Query("SELECT n FROM Course n WHERE n.courseName = ?1")
    Course findByName(String name);
    @Query("SELECT n FROM Course n WHERE n.id = ?1")
    Course findByid(Long id);
}