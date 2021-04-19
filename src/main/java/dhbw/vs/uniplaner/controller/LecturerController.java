package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Lecturer;
import dhbw.vs.uniplaner.service.LecturerService;
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
public class LecturerController {

    private final Logger log = LoggerFactory.getLogger(LecturerController.class);

    private LecturerService lecturerService;

    @Autowired
    public LecturerController (LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }


    @PostMapping("/lecturers")
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) throws BadRequestException, URISyntaxException {
        this.lecturerService.save(lecturer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code PUT  /lecturers} : Updates an existing Lecturer.
     *
     * @param lecturer the lecturer to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated lecturer,
     * or with status {@code 400 (Bad Request)} if the lecturer is not valid,
     * or with status {@code 500 (Internal Server Error)} if the lecturer couldn't be updated.
     * @throws BadRequestException if the lecturer ist not valid.
     */
    @PutMapping("/lecturers")
    public ResponseEntity<Lecturer> updateLecturer(@RequestBody Lecturer lecturer) throws  BadRequestException {
        return null;
    }

    @PutMapping("/lecturers/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable(value = "id") Long id,@Valid @RequestBody Lecturer lecturerDetails) throws ResourceNotFoundException {
        Optional<Lecturer> tempLecturer = this.lecturerService.findOne(id);
        tempLecturer.get().setEmail(lecturerDetails.getEmail());
        tempLecturer.get().setFirstName(lecturerDetails.getFirstName());
        tempLecturer.get().setLastName(lecturerDetails.getLastName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /lecturers} : get all the lecturers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of lecturers in body.
     */
    @GetMapping("/lecturers")
    public List<Lecturer> getAlllecturers() {
        return this.lecturerService.findAll();
    }

    /**
     * {@code GET  /lecturers/:id} : get the "id" lecturer.
     *
     * @param id the id of the lecturer to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the lecturer, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/lecturers/{id}")
    public ResponseEntity<Lecturer> getLecturer(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = this.lecturerService.findOne(id);

        if (lecturer.get().getId().equals(null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(lecturer.get(), HttpStatus.OK);
            // Versuch den Body hinzuzufügen, muss noch mit einer stabilen internetverbindung getestet werden
        }
    }
        /**
         * {@code DELETE  /lecturers/:id} : delete the "id" lecturer.
         *
         * @param id the id of the lecturer to delete.
         * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
         */
        @DeleteMapping("/lecturers/{id}")
        public ResponseEntity<Void> deleteLecturer(@PathVariable Long id) {
            this.lecturerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }




}
