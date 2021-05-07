package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Lecture;
import dhbw.vs.uniplaner.domain.Role;
import dhbw.vs.uniplaner.service.LectureService;
import dhbw.vs.uniplaner.exception.BadRequestException;
import dhbw.vs.uniplaner.exception.ResourceNotFoundException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LectureController {

    private final Logger log = LoggerFactory.getLogger(LectureController.class);

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }
    
    /*
     * BadRequestException wird geworfen wenn keine Verbindung,
     * RollenUID schon vergeben ist oder die Übergebene Rolle leer ist.
     * */
    
    @PostMapping("/lectures")
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture) throws BadRequestException, URISyntaxException {
        List<Lecture> aLecture;
        aLecture = lectureService.findAll();
        for( Lecture sLecture : aLecture) {
            if(sLecture.getLecture_id().equals(lecture.getLecture_id())){
                throw new BadRequestException("Rolle bereits vorhanden");
            }
        }
        this.lectureService.save(lecture);
        return new ResponseEntity("Rolle wurde erstellt", HttpStatus.OK);
    }
    

    @PutMapping("/lectures/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable(value = "id") Long id,@Valid @RequestBody Lecture lectureDetails) throws ResourceNotFoundException {
        Optional<Lecture> tempLecture = lectureService.findOne(id);
        if(tempLecture.isEmpty()){
            throw new ResourceNotFoundException("Vorlesung mit der ID " + lectureDetails.getLecture_id() + " nicht gefunden.");
        }
        tempLecture.get().setLecture_id(lectureDetails.getLecture_id());
        tempLecture.get().setLectureName(lectureDetails.getLectureName());
        tempLecture.get().setCourse(lectureDetails.getCourse());
        tempLecture.get().setDuration(lectureDetails.getDuration());
        tempLecture.get().setModulName(lectureDetails.getModulName());
    
        return new ResponseEntity("Vorlesung erfolgreich geändert", HttpStatus.OK);
    }

    /**
     * {@code GET  /lectures} : get all the lectures.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of lectures in body.
     */
    @GetMapping("/lectures")
    public List<Lecture> getAlllectures() {
        return this.lectureService.findAll();
    }

    /**
     * {@code GET  /lectures/:id} : get the "id" lecture.
     *
     * @param id the id of the lecture to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the lecture, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/lectures/{id}")
    public ResponseEntity<Lecture> getLecture(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Lecture> lecture = this.lectureService.findOne(id);

        if (lecture.get().getLecture_id() != id) {
            throw new ResourceNotFoundException("Rolle mit der ID " + id + " nicht gefunden.");
        }
        else {
            return new ResponseEntity<>(lecture.get(), HttpStatus.OK);
        }
    }
        
    /**
    * {@code DELETE  /lectures/:id} : delete the "id" lecture.
    *
    * @param id the id of the lecture to delete.
    * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
    */
    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        this.lectureService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
