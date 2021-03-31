package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse beschreibt mögliche Rollen von Benutzern im System (z.B. Dozent, Admin, Student, etc.)
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Role name")
    private String roleName;
    
    @Column(name = "Role UID")
    private String roleUid;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleUid() {
        return roleUid;
    }
    
    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }
    
    public Role roleName (String roleName){
        this.roleName = roleName;
        return this;
    }
    
    public Role roleUid (String roleUid){
        this.roleUid = roleUid;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        return id != null && id.equals(((Role) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Role{" +
            "id=" + getId() +
            ", roleName='" + getRoleName() + "'" +
            ", roleUid='" + getRoleUid() + "'" +
            "}";
    }
}
