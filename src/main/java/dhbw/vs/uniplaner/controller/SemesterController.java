package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Semester;
import dhbw.vs.uniplaner.service.SemesterService;
import dhbw.vs.uniplaner.exception.BadRequestException;
import dhbw.vs.uniplaner.exception.ResourceNotFoundException;


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
public class SemesterController {

    private final Logger log = LoggerFactory.getLogger(SemesterController.class);
    private SemesterService semService;

    @Autowired
    public SemesterController (SemesterService semService) {
        this.semService = semService;
    }


    @PostMapping("/semesters")
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) throws BadRequestException, URISyntaxException {
        this.semService.save(semester);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code PUT  /semesters} : Updates an existing Semester.
     *
     * @param semester the semester to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated semester,
     * or with status {@code 400 (Bad Request)} if the semester is not valid,
     * or with status {@code 500 (Internal Server Error)} if the semester couldn't be updated.
     * @throws BadRequestException if the semester ist not valid.
     */
    @PutMapping("/semesters")
    public ResponseEntity<Semester> updateSemester(@RequestBody Semester semester) throws  BadRequestException {
        return null;
    }

    @PutMapping("/semesters/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable(value = "id") Long id,@Valid @RequestBody Semester semesterDetails) throws ResourceNotFoundException {
        Optional<Semester> tempSemester = this.semService.findOne(id);
        tempSemester.get().setId(semesterDetails.getId());
        tempSemester.get().setCourse(semesterDetails.getCourse());
        tempSemester.get().setStartDate(semesterDetails.getStartDate());
        tempSemester.get().setEndDate(semesterDetails.getEndDate());
        tempSemester.get().setName(semesterDetails.getName());
        tempSemester.get().setNumber(semesterDetails.getNumber());
        tempSemester.get().setSemesterNumber(semesterDetails.getSemesterNumber());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /semesters} : get all the semesters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of semesters in body.
     */
    @GetMapping("/semesters")
    public List<Semester> getAllsemesters() {
        return this.semService.findAll();
    }

    /**
     * {@code GET  /semesters/:id} : get the "id" semester.
     *
     * @param id the id of the semester to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the semester, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/semesters/{id}")
    public ResponseEntity<Semester> getSemester(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Semester> semester =this.semService.findOne(id);

        if (semester.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(semester.get(), HttpStatus.OK);
        }
    }

    /**
    * {@code DELETE  /semesters/:id} : delete the "id" semester.
    *
    * @param id the id of the semester to delete.
    * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
    */
    @DeleteMapping("/semesters/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable Long id) {
        this.semService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
