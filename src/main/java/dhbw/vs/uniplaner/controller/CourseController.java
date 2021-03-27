package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Course;
import dhbw.vs.uniplaner.service.CourseService;
import dhbw.vs.uniplaner.exception.BadRequestException;
import dhbw.vs.uniplaner.exception.ResourceNotFoundException;
import dhbw.vs.uniplaner.interfaces.ICourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final Logger log = LoggerFactory.getLogger(CourseController.class);

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) throws BadRequestException, URISyntaxException {
        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code PUT  /courses} : Updates an existing Course.
     *
     * @param course the course to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated course,
     * or with status {@code 400 (Bad Request)} if the course is not valid,
     * or with status {@code 500 (Internal Server Error)} if the course couldn't be updated.
     * @throws BadRequestException if the course ist not valid.
     */
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws  BadRequestException {
        ResponseEntity<Course> response = null;

        Optional<Course> tempCourse  = courseService.findOne(course.getId());
        
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long id,@Valid @RequestBody Course courseDetails) throws ResourceNotFoundException {
        Optional<Course> tempCourse = courseService.findOne(id);
        tempCourse.get().setCourseName(courseDetails.getCourseName());
        tempCourse.get().setStartDate(courseDetails.getStartDate());
        tempCourse.get().setEndDate(courseDetails.getEndDate());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /courses} : get all the courses.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courses in body.
     */
    @GetMapping("/courses")
    public List<Course> getAllcourses() {
        return this.courseService.findAll();
    }

    /**
     * {@code GET  /courses/:id} : get the "id" course.
     *
     * @param id the id of the course to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the course, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Course> course = courseService.findOne(id);

        if (course.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
            //Hier fehlt als der Body, der mit dem Status übergegeben werden muss
        }
    }
        /**
         * {@code DELETE  /courses/:id} : delete the "id" course.
         *
         * @param id the id of the course to delete.
         * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
         */
        @DeleteMapping("/courses/{id}")
        public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
            courseService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }




}
