package dhbw.vs.uniplaner.repository;

import dhbw.vs.uniplaner.domain.Course;
import dhbw.vs.uniplaner.domain.DegreeProgram;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, Long> {
	@Query("SELECT n FROM DegreeProgram n WHERE n.name = ?1")
	DegreeProgram findByName(String name);
}