package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.Role;
import dhbw.vs.uniplaner.service.RoleService;
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
public class RoleController {

    private final Logger log = LoggerFactory.getLogger(RoleController.class);
    
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) throws BadRequestException, URISyntaxException {
        this.roleService.save(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code PUT  /roles} : Updates an existing Role.
     *
     * @param role the role to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated role,
     * or with status {@code 400 (Bad Request)} if the role is not valid,
     * or with status {@code 500 (Internal Server Error)} if the role couldn't be updated.
     * @throws BadRequestException if the role ist not valid.
     */
    @PutMapping("/roles")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) throws  BadRequestException {
        return null;
    }

    @PutMapping("/roles/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long id,@Valid @RequestBody Role roleDetails) throws ResourceNotFoundException {
        Optional<Role> tempRole = this.roleService.findOne(id);
        tempRole.get().setId(roleDetails.getId());
        tempRole.get().setRoleName(roleDetails.getRoleName());
        tempRole.get().setRoleUid(roleDetails.getRoleName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * {@code GET  /roles} : get all the roles.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of roles in body.
     */
    @GetMapping("/roles")
    public List<Role> getAllroles() {
        return this.roleService.findAll();
    }

    /**
     * {@code GET  /roles/:id} : get the "id" role.
     *
     * @param id the id of the role to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the role, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Role> role = this.roleService.findOne(id);

        if (role.get().equals(null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(role.get(), HttpStatus.OK);
        }
    }

    /**
    * {@code DELETE  /roles/:id} : delete the "id" role.
    *
    * @param id the id of the role to delete.
    * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
    */
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        this.roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }       




}
