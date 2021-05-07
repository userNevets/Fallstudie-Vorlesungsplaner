package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Lecturer;
import dhbw.vs.uniplaner.domain.Role;
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

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController (LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }
    
    /*
     * BadRequestException wird geworfen wenn keine Verbindung,
     * RollenUID schon vergeben ist oder die Übergebene Rolle leer ist.
     * */

    @PostMapping("/lecturers")
    public ResponseEntity<Lecturer> createLecturer(@RequestBody Lecturer lecturer) throws BadRequestException, URISyntaxException {
        List<Lecturer> aLecturer;
        aLecturer = lecturerService.findAll();
        for( Lecturer sLecturer : aLecturer) {
            if(sLecturer.getId().equals(lecturer.getId())){
                throw new BadRequestException("Dozent bereits vorhanden");
            }
        }
        this.lecturerService.save(lecturer);
        return new ResponseEntity("Dozent wurde erstellt", HttpStatus.OK);
    }
    

    @PutMapping("/lecturers/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable(value = "id") Long id,@Valid @RequestBody Lecturer lecturerDetails) throws ResourceNotFoundException {
        Optional<Lecturer> tempLecturer = this.lecturerService.findOne(id);
        if(tempLecturer.isEmpty()){
            throw new ResourceNotFoundException("Dozent mit der ID " + lecturerDetails.getId() + " nicht gefunden.");
        }
        tempLecturer.get().setEmail(lecturerDetails.getEmail());
        tempLecturer.get().setFirstName(lecturerDetails.getFirstName());
        tempLecturer.get().setLastName(lecturerDetails.getLastName());
    
        return new ResponseEntity("Dozent erfolgreich geändert", HttpStatus.OK);
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

        if (lecturer.get().getId() != id) {
            throw new ResourceNotFoundException("Dozent mit der ID " + id + " nicht gefunden.");
        }
        else {
            return new ResponseEntity<>(lecturer.get(), HttpStatus.OK);
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
