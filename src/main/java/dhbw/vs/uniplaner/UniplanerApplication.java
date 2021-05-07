package dhbw.vs.uniplaner;


import dhbw.vs.uniplaner.domain.*;
import dhbw.vs.uniplaner.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static net.minidev.json.JSONValue.parse;

@SpringBootApplication
public class UniplanerApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private LectureRepository lectureRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private SemesterRepository semesterRepository;
	@Autowired
	private LecturerRepository lecturerRepository;
	@Autowired
	private DegreeProgramRepository degreeProgramRepository;
	@Autowired
	private UniUserRepository uniUserRepository;
	
	


	public static void main(String[] args) {
		SpringApplication.run(UniplanerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
		if(roleRepository.count() ==0){
			Role role1 = new Role("Dozent", "1");
			Role role2 = new Role("Admin", "1");
			roleRepository.save(role1);
			roleRepository.save(role2);
		}
		if(degreeProgramRepository.count() ==0){
			DegreeProgram degree1 = new DegreeProgram("Bachelor of Arts", "BA");
			DegreeProgram degree2 = new DegreeProgram("Bachelor of Science", "BS");
			DegreeProgram degree3 = new DegreeProgram("Bachelor of Technic", "BT");
			degreeProgramRepository.save(degree1);
			degreeProgramRepository.save(degree2);
			degreeProgramRepository.save(degree3);
			degree1.addCourse(courseRepository.findByName("WWI2022A"));
			degree2.addCourse(courseRepository.findByName("WWI2022B"));
			degree3.addCourse(courseRepository.findByName("WWI2022C"));
		}
		if(courseRepository.count() ==0){
			Course course1 = new Course("WWI2022A", null, null);
			Course course2 = new Course("WWI2022B",null, null);
			Course course3 = new Course("WWI2022C",null, null);
			course1.setStartingYear(2022L);
			course2.setStartingYear(2022L);
			course3.setStartingYear(2022L);
			course1.setDegreeProgram(degreeProgramRepository.findByName("Bachelor of Arts"));
			course2.setDegreeProgram(degreeProgramRepository.findByName("Bachelor of Science"));
			course3.setDegreeProgram(degreeProgramRepository.findByName("Bachelor of Technic"));
			courseRepository.save(course1);
			courseRepository.save(course3);
			courseRepository.save(course2);
		}
		if(uniUserRepository.count() ==0){
			UniUser user1 = new UniUser("Kai", "Kaiser", "sto@no-spam.ws", "oBA6S6gCBG4KF7lwtCZhvO2uuhGpXT9Aeg3xoWiu78hNNQD1B2bCW");
			UniUser user2 = new UniUser("Admin", "Admin", "Admin@no-spam.ws", "oBA6S6gCBG4KF7lwtCZhvO2uuhGpXT9Aeg3xoWiu78hNNQD1B2bCW");
			uniUserRepository.save(user1);
			uniUserRepository.save(user2);
		}
		if(lectureRepository.count() ==0){
			Lecture lecture1 = new Lecture("Einführung", "Einführung", 53L);
			Lecture lecture2 = new Lecture("IT", "Einführung IT", 9L);
			Lecture lecture3 = new Lecture("Webprogrammierung", "Programmierung", 20L);
			lectureRepository.save(lecture1);
			lectureRepository.save(lecture2);
			lectureRepository.save(lecture3);
		}
		if(lecturerRepository.count() ==0){
			Lecturer lecturer = new Lecturer(uniUserRepository.findByEmail("sto@no-spam.ws").getfirst_name(), uniUserRepository.findByEmail("sto@no-spam.ws").getlast_name(), uniUserRepository.findByEmail("sto@no-spam.ws").getemail());
			lecturer.addLecture(lectureRepository.findByName("Einführung"));
			lecturer.addLecture(lectureRepository.findByName("IT"));
			lecturerRepository.save(lecturer);
		}
		
		String x = "this server is working";
		System.out.println(x);



	}

}
