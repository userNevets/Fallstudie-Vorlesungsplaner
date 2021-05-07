package dhbw.vs.uniplaner.repository;

import dhbw.vs.uniplaner.domain.Lecture;

import dhbw.vs.uniplaner.domain.UniUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface LectureRepository extends JpaRepository<Lecture, Long> {
	@Query("SELECT n FROM Lecture n WHERE n.lectureName = ?1")
	Lecture findByName(String lectureName);
}