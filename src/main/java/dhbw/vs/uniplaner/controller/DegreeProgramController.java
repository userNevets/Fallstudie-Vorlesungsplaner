package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.DegreeProgram;
import dhbw.vs.uniplaner.service.DegreeProgramService;
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
public class DegreeProgramController {

    private final Logger log = LoggerFactory.getLogger(DegreeProgramController.class);

    private DegreeProgramService dpServive;

    @Autowired
    public DegreeProgramController(DegreeProgramService deg_service) {
        this.dpServive = deg_service;
    }


    @PostMapping("/degreeprograms")
    public ResponseEntity<DegreeProgram> createDegreeProgram(@RequestBody DegreeProgram degreeprogram) throws BadRequestException, URISyntaxException {
        this.dpServive.save(degreeprogram);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code PUT  /degreeprograms} : Updates an existing DegreeProgram.
     *
     * @param degreeprogram the degreeprogram to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated degreeprogram,
     * or with status {@code 400 (Bad Request)} if the degreeprogram is not valid,
     * or with status {@code 500 (Internal Server Error)} if the degreeprogram couldn't be updated.
     * @throws BadRequestException if the degreeprogram ist not valid.
     */
    @PutMapping("/degreeprograms")
    public ResponseEntity<DegreeProgram> updateDegreeProgram(@RequestBody DegreeProgram degreeprogram) throws  BadRequestException {
        return null;
    }

    @PutMapping("/degreeprograms/{id}")
    public ResponseEntity<DegreeProgram> updateDegreeProgram(@PathVariable(value = "id") Long id,@Valid @RequestBody DegreeProgram degreeprogramDetails) throws ResourceNotFoundException {
        Optional<DegreeProgram> tempDegreeProgram = this.dpServive.findOne(id);
        tempDegreeProgram.get().setName(degreeprogramDetails.getName());
        tempDegreeProgram.get().setShortName(degreeprogramDetails.getShortName());
        tempDegreeProgram.get().setDeg_id(degreeprogramDetails.getDeg_id());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /degreeprograms} : get all the degreeprograms.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of degreeprograms in body.
     */
    @GetMapping("/degreeprograms")
    public List<DegreeProgram> getAlldegreeprograms() {
        return this.dpServive.findAll();
    }

    /**
     * {@code GET  /degreeprograms/:id} : get the "id" degreeprogram.
     *
     * @param id the id of the degreeprogram to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the degreeprogram, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/degreeprograms/{id}")
    public ResponseEntity<DegreeProgram> getDegreeProgram(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<DegreeProgram> degreeProgram = this.dpServive.findOne(id);

        if (degreeProgram.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<DegreeProgram>(HttpStatus.OK);
            //Hier fehlt als der Body, der mit dem Status übergegeben werden muss

        }
    }
        /**
         * {@code DELETE  /degreeprograms/:id} : delete the "id" degreeprogram.
         *
         * @param id the id of the degreeprogram to delete.
         * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
         */
        @DeleteMapping("/degreeprograms/{id}")
        public ResponseEntity<Void> deleteDegreeProgram(@PathVariable Long id) {
            dpServive.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }




}
